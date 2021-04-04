package a01203138;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class FinalExam2 {

	private String data;
	
	public FinalExam2(String data) {
		this.data = data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File("q2.txt"));
			String row = "";

			while (scanner.hasNext()) {
				row += scanner.nextLine() + ":";
			}
			new FinalExam2(row).run();
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.exit(1);
		}
	}
	
	public void run() {
		String[] pms = data.split(":");
		LocalDate endDay;

		File filename = new File("PM.txt");
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			PrintStream out = new PrintStream(fileOut);
			
			for (String pm : pms) {
				String name = pm.split(" ")[1] + " " + pm.split(" ")[0];
				String startDate = pm.split(" ")[2];
				String endDate = pm.split(" ")[3];
				
				LocalDate startDay = convert(startDate);
				if (endDate.equals("now")) {
					endDay = LocalDate.now();
				}
				else {
					endDay = convert(endDate);
				}

				long daysServe = startDay.until(endDay, ChronoUnit.DAYS);
				out.printf("%10s  %10s \n", name, daysServe);
			}
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static LocalDate convert(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd")
				.withResolverStyle(ResolverStyle.STRICT);
		@SuppressWarnings("unused")
		LocalDate dt = LocalDate.parse(date, formatter);
		return dt;
    }
}
