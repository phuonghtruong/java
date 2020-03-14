/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Brian Truong
 * Mar. 1, 2020
 * InsuranceCompany.java
 */
import java.util.ArrayList;
import java.util.Collections;

public class InsuranceCompany {

	private String companyName;
	private ArrayList<ProjectInvoice> listOfInvoices;
	
	private static final double INSURANCE_RATE_FOR_LABOUR = 0.05;
	private static final double INSURANCE_RATE_FOR_LABOUR_MATERIAL = 0.07;
	private static final double INSURANCE_RATE_FOR_LABOUR_MATERIAL_EQUIP = 0.1;
	
	private static final int MIN_LENGTH_OF_INVOICE_NUMBER = 7;
	/**
	 * 
	 */
	public InsuranceCompany(String companyName) {
		// TODO Auto-generated constructor stub
		listOfInvoices = new ArrayList<ProjectInvoice>();
		setCompanyName(companyName);
	}
	
	public void setCompanyName(String companyName) {
		if(companyName == null || companyName.isBlank() || companyName.isEmpty()) {
			throw new IllegalArgumentException("Company name cannot be null or empty string");
		}
		else {
			this.companyName = companyName;
		}
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void addProjectInvoice(ProjectInvoice invoice) {
		if(invoice !=null) {
			listOfInvoices.add(invoice);
		}
	}
	
	public void displayProjectInvoice(String invoiceNumber) throws InvalidInvoiceNumberException{
		//try catch here
		boolean isFound = false;
		if(invoiceNumber != null && invoiceNumber.length() >= MIN_LENGTH_OF_INVOICE_NUMBER)
			for(ProjectInvoice invoice : listOfInvoices) {
				if(invoice.getInvoiceNumber().equalsIgnoreCase(invoiceNumber)){
					isFound = true;
					System.out.println(invoice);
				}
			}
		else {
			throw new InvalidInvoiceNumberException("The invoice number " + invoiceNumber + " must at least 7 characters");	
		}
		if(!isFound) {
			System.out.println("Invoice was not found!!!");
		}
	}
	
	public double calculateTotalInsuranceFees() {
		double totalFees = 0;
		for(ProjectInvoice invoice : listOfInvoices) {
			if(invoice instanceof Labour){
				totalFees += invoice.calculateTotalCost() * INSURANCE_RATE_FOR_LABOUR;
			}
			if(invoice instanceof LabourAndMaterial) {
				totalFees += invoice.calculateTotalCost() * INSURANCE_RATE_FOR_LABOUR_MATERIAL;
			}
			if(invoice instanceof LabourAndMaterialAndEquipment) {
				totalFees += invoice.calculateTotalCost() * INSURANCE_RATE_FOR_LABOUR_MATERIAL_EQUIP;
			}
		}
		return totalFees;
	}

	public void displayInvoiceNumberAndProjectCost() {
		Collections.sort(listOfInvoices);
		for(ProjectInvoice inv : listOfInvoices) {
			System.out.println("Invoice Number: " + inv.getInvoiceNumber());
			System.out.println("Project cost: " + inv.calculateTotalCost());
			System.out.println();
		}
	}
}
