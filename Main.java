import java.util.ArrayList;
import java.util.List;

class Main {
public static void main(String args[]) {

	List<Show> list=new ArrayList<Show>();
		
		ShowManager dmi=new ShowManagerImpl();
		list=dmi.populate("show.txt");
		System.out.println("SHOWS ARE AS FOLLOWS::"+list);
		


		try {
			dmi.bookShow(list, "Sahi re Sahi", "6.30pm", 3);
			
			System.out.println(list);
		}catch(Exception e) {
			
		}
   }
}

