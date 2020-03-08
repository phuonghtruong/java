/**
 * 
 */
package ca.bcit.comp1451.session8A;

/**
 * @author A01203138
 *
 */
import java.util.ArrayList;
public class Driver {

	/**
	 * @param args
	 */
	private static ArrayList<Displayable> list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list = new ArrayList<Displayable>();
		
		Date d1 = new Date(2,7,2017);
		Clock c1 = new TwelveHourClock(2,8,3, "am");
		Clock c2 = new TwelveHourClock(10,18,35,"pm");
		
		Clock c3 = new TwentyfourHourClock(5,1,0);
		Clock c4 = new TwentyfourHourClock(18,10,5);
		
		list.add(d1);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		
		for(Displayable l : list) {
			System.out.println(l.getStringValue());
		}
		
	}

}
