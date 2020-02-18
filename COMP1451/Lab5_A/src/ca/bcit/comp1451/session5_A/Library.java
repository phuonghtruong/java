/**
 * 
 */
package ca.bcit.comp1451.session5_A;

/**
 * @author A01203138
 *
 */
import java.util.ArrayList;

public class Library {
	private ArrayList<ReadingMaterial> objectList;
	
	public Library() {
		objectList = new ArrayList<ReadingMaterial>();
	}
	
	public void loadLibrary(ReadingMaterial object) {
		if(object instanceof TextBook || object instanceof Magazine || object instanceof Novel) {
			objectList.add(object);
		}		
	}
	
	public void displayAllMaterialDetails() {
		for(ReadingMaterial object : objectList) {
			if(object instanceof TextBook) {
				((TextBook) object).displayDetails();
			}
			else if(object instanceof Novel) {
				((Novel) object).displayDetails();
			}
			else if(object instanceof Magazine) {
				((Magazine) object).displayDetails();
			}
		}
	}
	
	public void displayMagazineDetails() {
		for(ReadingMaterial object : objectList) {
			if(object instanceof Magazine) {
				((Magazine) object).displayDetails();
			}
		}
	}
	
	public static void main(String[] args) {
		Library l1 = new Library();
		
		TextBook t1 = new TextBook("how to be rich", 500, 3, "OMG", "Economy");
		Novel n1 = new Novel("how", 340, "lily", "thriller", "Gangster");
		Magazine m1 = new Magazine("Green scarf", 50, "30/Feb/2020", 4000);
		
		l1.loadLibrary(m1);
		l1.loadLibrary(n1);
		l1.loadLibrary(t1);
		
		l1.displayMagazineDetails();
		System.out.println("======================");
		l1.displayAllMaterialDetails();
	}
}
