import java.util.List;

public class ShowImpl implements DisplayShow {

	
	@Override
	public void displayAllShows(List<Show> shows) {
		shows.forEach(System.out::println);

	}
}
