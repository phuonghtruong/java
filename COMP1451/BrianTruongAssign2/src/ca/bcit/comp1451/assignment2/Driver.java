/**
 * 
 */
package ca.bcit.comp1451.assignment2;

import ca.bcit.comp1451.assignment2.Labour.Criteria;
import ca.bcit.comp1451.assignment2.Labour.TypeOfLabour;

/**
 * @author Brian Truong
 * Mar. 1, 2020
 * Driver.java
 */
import java.util.Scanner;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		InsuranceCompany comp1 = new InsuranceCompany("AllInsured");
		
		ProjectInvoice labour1 = new Labour("Trident", 200, 32.5 , 1500, 
				              Criteria.OVERTIME, TypeOfLabour.INEXPERIENCED );
		ProjectInvoice labour2 = new Labour("Montana", 300, 35.5 , 1000, 
                              Criteria.REGULAR, TypeOfLabour.EXPERIENCED );
		
		ProjectInvoice labourAndMaterial1 = new LabourAndMaterial("RockyMountain",
				200, 36.5 , 500, Criteria.REGULAR, TypeOfLabour.INEXPERIENCED,
				1500, 20, 15);
		ProjectInvoice labourAndMaterial2 = new LabourAndMaterial("GrouseMountain",
				250, 30.5 , 800, Criteria.HOLIDAY, TypeOfLabour.EXPERIENCED,
				2000, 30, 25);
		
		ProjectInvoice labourMaterialEquipment1 = new LabourAndMaterialAndEquipment(
				"HuntsRock", 150, 25 , 100, 
				Criteria.OVERTIME, TypeOfLabour.INEXPERIENCED,
				2500, 5, 50, 1500, 48);
		ProjectInvoice labourMaterialEquipment2 = new LabourAndMaterialAndEquipment(
				"Avenger", 250, 40 , 200, 
				Criteria.REGULAR, TypeOfLabour.EXPERIENCED,
				1000, 10, 100, 2500, 60);
		
		comp1.addProjectInvoice(labour1);
		comp1.addProjectInvoice(labour2);
		comp1.addProjectInvoice(labourAndMaterial1);
		comp1.addProjectInvoice(labourAndMaterial2);
		comp1.addProjectInvoice(labourMaterialEquipment1);
		comp1.addProjectInvoice(labourMaterialEquipment2);
		
		comp1.displayInvoiceNumberAndProjectCost();
		System.out.println("Total Insurance fees: " + comp1.calculateTotalInsuranceFees());
		
		while(true) {
			
			System.out.println("Enter an invoice number: ");
			String invoiceNumber = input.next();
			try {
				comp1.displayProjectInvoice(invoiceNumber);
			}catch(InvalidInvoiceNumberException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Do you continue with other invoice ? (y|n) : ");
			String ans = input.next();
			if("n".equalsIgnoreCase(ans)) {
				System.out.println("Thank you and see you again!");
				break;
			}
	
			
		}
	}

}
