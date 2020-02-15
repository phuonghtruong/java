/**
 * 
 */
package ca.bcit.comp1451.Session1LabB;

/**
 * @author Brian Truong
 *
 */
import java.util.*;

public class Club {

	private ArrayList<Member> memberList;
	/**
	 * Constructor Club class
	 */
	public Club() {
		// TODO Auto-generated constructor stub
		memberList = new ArrayList<Member>();
	}
	/**
	 * 
	 * @param member
	 */
	public void join(Member member) {
		if(member != null) {
			memberList.add(member);
		}
	}
	/**
	 * 
	 * @return size of memberList
	 */
	public int numberOfMembers() {
		return memberList.size();
	}

	public void showMembers() {
		for(Member member:memberList) {
			member.displayDetails();
		}
	}
	
	/**
	 * 
	 * @param year
	 */
	public void showMembersByYear(int year) {
		boolean isFound = false;
		for(Member member:memberList) {
			if(member.getYearOfJoining() == year) {
				member.displayDetails();
				isFound = true;
			}
		}
		if(!isFound) {
			System.out.println("No member with requested year is found!!!");
		}
	}
	/**
	 * 
	 * @param year
	 */
	public void removeMembersByYear(int year) {
		Iterator<Member> it = memberList.iterator();
		boolean isFound = false;
		while(it.hasNext()) {
			Member member = it.next();
			if(member.getYearOfJoining() == year) {
				isFound = true;
				it.remove();				
			}
		}
		if(!isFound) {
			System.out.println("No member with requested year is found!!!");
		}
	}
}
