
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

	public static void main(String[] args) {
	
		//list candidate names from Pune city
		System.out.println("List of Pune Candidates:");
		InterviewRepository.getCandidateList().stream().filter(can -> can.getCity().equals("Pune")).forEach(System.out::println);

		//list city and count of candidates per city
		System.out.println("Candidate count per city");
		Map<String, Long> candidatePerCity = InterviewRepository.getCandidateList().stream().collect(Collectors.groupingBy(Candidate::getCity,
				TreeMap::new, Collectors.counting()));
		
		candidatePerCity.forEach((city, count) -> System.out.println("City: " + city + ", Count: " + count));
		

		//list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise");
		Map<String, Long> candidatePerExpertise = InterviewRepository.getCandidateList().stream().collect(Collectors.groupingBy(Candidate::getTechnicalExpertise,
				TreeMap::new, Collectors.counting()));
		
		candidatePerExpertise.forEach((expertise, count) -> System.out.println("Expertise: " + expertise + ", Count: " + count));
		
		//list fresher candidates
		System.out.println("Fresher Candidate list");
		InterviewRepository.getCandidateList().stream().filter(can -> can.getYearsOfExperience() == 0).forEach(System.out::println);
		//listing candidates with highest experience
        System.out.println("Sorted List of Candidates by Experience");
        InterviewRepository.getCandidateList().stream()
        .sorted((o1, o2) -> o1.getYearsOfExperience() > o2.getYearsOfExperience() ? 1
        		: o1.getYearsOfExperience() < o2.getYearsOfExperience() ? -1 : 0).forEach(System.out::println);

		//sort the candidates by city name
		printLine();
		System.out.println("Sorted List of Candidates by City Name");
		InterviewRepository.getCandidateList().stream()
        .sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity())).forEach(System.out::println);
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}
}
