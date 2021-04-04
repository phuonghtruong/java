package week2_demo;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Java";
		System.out.println(Integer.toHexString(s.hashCode()));
		s = "Hello";
		System.out.println(Integer.toHexString(s.hashCode()));
		s = "Java";
		System.out.println(Integer.toHexString(s.hashCode()));
		
		String s1 = new String("noono");
		String s2 = "noono";
		if (s1.equals(s2)) {
			System.out.println("Content is equal");
		}
		
		if (s1 == s2) {
			System.out.println("Address is the same");
		}
	}

}
