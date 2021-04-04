package a01203138.data;


public class quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting data");
			System.exit(-1);
		}
		
		String[] studentInfo = args[0].split("\\|");

		String id = studentInfo[0];
		String firstName = studentInfo[1];
		String lastName = studentInfo[2];
		String phone = studentInfo[4];
		String emailAddress = studentInfo[3];
		
		Student student = new Student.Builder(id, emailAddress)
				   .firstName(firstName)
				   .lastName(lastName)
				   .phone(phone)
				   .build();
		System.out.println(student);
	}

}
