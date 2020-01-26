package ca.bcit.comp1451.Session1LabB;

public class Driver {

	public static void main(String[] args) {
		Member m1 = new Member(args[0], args[1], 
				Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		Member m2 = new Member(args[4], args[5], 
				Integer.parseInt(args[6]), Integer.parseInt(args[7]));
		Club c1 = new Club();
		c1.join(m1);
		c1.join(m2);
		
		System.out.println("Total members in the club: " + c1.numberOfMembers());
		c1.showMembers();
		
		System.out.println("\n**********");
		System.out.println("Show only members joining in 2019");
		c1.showMembersByYear(2019);
		System.out.println("Show only members joining in 2018");
		c1.showMembersByYear(2018);
		
		System.out.println("\n**********");
		System.out.println("Remove member joining in 2016");
		c1.removeMembersByYear(2016);
		
		System.out.println("Remove member joining in 2017");
		c1.removeMembersByYear(2017);
		c1.showMembers();
		
	}

}
