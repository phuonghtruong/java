package a01203138;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lab8 {

	private static final Instant startTime = Instant.now();
	public static final String HEADER_FORMAT = "%4s %4s %5s %10s %12s %12s %12s %10s%n";
	public static final String RUNNER_FORMAT = "%4d %4d %5s %10s %12s %12s %12.3f %10.3f%n";
	
	private List<Runner> listRunner;
	private Runner runner1;
	private Runner runner2;
	private Runner runner3;
	private Runner runner4;
	private Runner runner5;
	private Runner runner6;
	private Runner runner7;
	private Runner runner8;
	
	public static void main(String[] args) {
		System.out.println("Start: " + startTime);		
		try {
			new Lab8().run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant endTime = Instant.now();
		System.out.println("End: " + endTime);
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Duration: " + duration.toMillis() + " ms");
	}

	private void run() throws InterruptedException {

		runner1 = new Runner.Builder(2612)
				.setFirstName("Usain").setLastName("BOLT").setCountry("JAM")
				.setLane(6).setReactionTime(155).build();
		runner2 = new Runner.Builder(3069)
				.setFirstName("Justin").setLastName("GATLIN").setCountry("USA")
				.setLane(4).setReactionTime(152).build();		
		runner3 = new Runner.Builder(2196)
				.setFirstName("Andre").setLastName("DEGRASSE").setCountry("CAN")
				.setLane(7).setReactionTime(141).build();
		runner4 = new Runner.Builder(2611)
				.setFirstName("Yohan").setLastName("BLAKE").setCountry("JAM")
				.setLane(9).setReactionTime(145).build();
		runner5 = new Runner.Builder(2909)
				.setFirstName("Akani").setLastName("SIMBINE").setCountry("RSA")
				.setLane(3).setReactionTime(128).build();
		runner6 = new Runner.Builder(2245)
				.setFirstName("Ben Youssef").setLastName("MEITE").setCountry("CIV")
				.setLane(8).setReactionTime(156).build();
		runner7 = new Runner.Builder(3054)
				.setFirstName("Trayvon").setLastName("BROMELL").setCountry("USA")
				.setLane(2).setReactionTime(135).build();
		runner8 = new Runner.Builder(2434)
				.setFirstName("Jimmy").setLastName("VICAUT").setCountry("FRA")
				.setLane(5).setReactionTime(140).build();
		
	
		runner1.start();
		runner2.start();
		runner3.start();
		runner4.start();
		runner5.start();
		runner6.start();
		runner7.start();
		runner8.start();
		
		runner1.join();
		runner2.join();
		runner3.join();
		runner4.join();
		runner5.join();
		runner6.join();
		runner7.join();
		runner8.join();
		
		listRunner = new ArrayList<Runner>();
		listRunner.add(runner1);
		listRunner.add(runner2);
		listRunner.add(runner3);
		listRunner.add(runner4);
		listRunner.add(runner5);
		listRunner.add(runner6);
		listRunner.add(runner7);
		listRunner.add(runner8);
		
		Collections.sort(listRunner);
		printResult(listRunner);
	}
	
	private static void printResult(List<Runner> runners) {
		System.out.println("=".repeat(80));
		System.out.printf(HEADER_FORMAT, "Rank", "Lane", "Bid#", "Country", "Last Name", "First Name", "Reaction", "Result");
		
		int index = 1;
		for(Runner runner : runners) {
			System.out.printf(RUNNER_FORMAT, index
										   , runner.getLane()
										   , runner.getBibNumber()
										   , runner.getCountry()
										   , runner.getLastName()
										   , runner.getFirstName()
										   , (float)runner.getReactionTime() / 1000
										   , (float)runner.getTimeInMs() / 1000);
			index++;
		}
		System.out.println("=".repeat(80));
	}

	
}
