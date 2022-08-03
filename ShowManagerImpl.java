import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowManagerImpl implements ShowManager {

	@Override
	public List<Show> populate(String fileName) {
		try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {
	        List<Show> showList = fileStream.map(line -> {
	            String[] arr = line.split(",");
	            return new Show(arr[0], arr[1], Integer.parseInt(arr[2]));
	        }).collect(Collectors.toList());
	        
	        return showList;
	    }
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats) throws
	 SeatsNotAvailableException, UnknownShowException, InvalidShowTimeException
	
	{
	
		if(!showList.stream().anyMatch(show -> show.getShowName().equalsIgnoreCase(showName))) {
			throw new UnknownShowException("This Show is not available");
		}
		
		else {
			Optional<Show> show1 = showList.stream().filter(show -> show.getShowName().equals(showName))
					.filter(show -> show.getShowTime().equals(show_time)).findAny();
			
			if(!show1.isPresent()) {
				throw new InvalidShowTimeException("Show at this time is not available");
			}
			
			else if(show1.get().getSeatsAvailable() < noOfSeats) {
				throw new SeatsNotAvailableException("Seats not available");
			}
			
			else {
				showList=showList.stream().filter(show -> show.getShowName().equals(showName))
						.filter(s -> s.getShowTime().equals(show_time))
						.peek(show -> show.setSeatsAvailable(show.getSeatsAvailable() - noOfSeats))
					    .collect(Collectors.toList());
			}
		}
		
		
	}

}
