package a01203138.book;

import java.io.IOException;

public class BookRunner {
	public static void main(String[] args) throws IOException{
		new BookRunner().run();
	}
	
	private void run() throws IOException {
		System.err.println("Run three reports -c -b -p");
		String[] proAgrs_1 = {"-c", "-b", "-p"};
		BookStore.main(proAgrs_1);
		System.err.println("PAUSE 1 ---------");
		System.in.read();
		System.in.read();
		
		System.err.println("Run customer reports -c -J -d");
		String[] proAgrs_2 = {"-c", "-J", "-d"};
		BookStore.main(proAgrs_2);
		System.err.println("PAUSE 2 ---------");
		System.in.read();
		System.in.read();
		
		System.err.println("Run book reports -b -A");
		String[] proAgrs_3 = {"-b", "-A"};
		BookStore.main(proAgrs_3);
		System.err.println("PAUSE 3 ---------");
		System.in.read();
		System.in.read();
		
		System.err.println("Run purchase reports -p -T -t");
		String[] proAgrs_4 = {"-p", "-T", "-t"};
		BookStore.main(proAgrs_4);
		System.err.println("PAUSE 4 ---------");
		System.in.read();
		System.in.read();
		
		System.err.println("Run purchase reports -p -C=XXXX -t -T -d");
		String[] proAgrs_5 = {"-p", "-C=8479", "-t" , "-T", "-d"};
		BookStore.main(proAgrs_5);
		System.err.println("PAUSE 5 ---------");
		System.in.read();
		System.in.read();
		
		System.err.println("Run purchase reports -p -C=XXXX -t -T -d");
		String[] proAgrs_6 = {"-p", "-C=8000", "-t" , "-T", "-d"};
		BookStore.main(proAgrs_6);
		System.err.println("PAUSE 6 ---------");
		System.in.read();
		System.in.read();
	}
}
