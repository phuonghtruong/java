package a01203138;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import a01203138.data.MusicMedia;
import a01203138.data.music.AudioFile;
import a01203138.data.music.CompactDisk;
import a01203138.data.music.VinylRecordAlbum;

public class Lab1 {

	public static void main(String[] args) {

		Lab1 lab1 = new Lab1();
		lab1.test();

		VinylRecordAlbum mm1 = new VinylRecordAlbum("Spin Me", "The Spinners", 12);
		System.out.println(mm1);
		mm1.setWeight(110);
		System.out.println(mm1);
		mm1.setWeight(180);
		System.out.println(mm1);
		mm1.play();

		CompactDisk mm2 = new CompactDisk("Turnabout Intruder", "Jim Kirk", 9);
		System.out.println(mm2);
		mm2.play();

		AudioFile mm3 = new AudioFile("Buzz-Click", "Cyber Punks", "Wish I Bought Vinyl.m4a", 3.46);
		System.out.println(mm3);
		mm3.save("C:/My Music/iTunes", mm3.getFileName());
		mm3.play();
		mm3.delete("C:/My Music/iTunes", mm3.getFileName());

	}

	@Test
	public void test() {
		// MusicMedia Tests
		assertThrows(IllegalArgumentException.class, () -> {
			MusicMedia mm = new AudioFile();
			mm.setTitle("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			MusicMedia mm = new AudioFile();
			mm.setTitle(null);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			MusicMedia mm = new AudioFile();
			mm.setArtist("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			MusicMedia mm = new AudioFile();
			mm.setArtist(null);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			AudioFile af = new AudioFile();
			af.setFileName("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			AudioFile af = new AudioFile();
			af.setFileName(null);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			AudioFile af = new AudioFile();
			af.setFileSize(-1);
		});
		
		// CompactDisk Tests
		assertThrows(IllegalArgumentException.class, () -> {
			CompactDisk cd = new CompactDisk();
			cd.setNumberOfTracks(-1);
		});

		CompactDisk cd = new CompactDisk();
		assertEquals(0, cd.getNumberOfTracks());
		cd.setNumberOfTracks(20);
		assertEquals(20, cd.getNumberOfTracks());
		cd.setNumberOfTracks(0);
		assertEquals(0, cd.getNumberOfTracks());

		assertThrows(IllegalArgumentException.class, () -> {
			VinylRecordAlbum vr = new VinylRecordAlbum();
			vr.setNumberOfTracks(-1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			VinylRecordAlbum vr = new VinylRecordAlbum();
			vr.setWeight(-1);
		});
		
		// VinylRecordAlbum Tests
		VinylRecordAlbum vr = new VinylRecordAlbum("Spin Me", "The Spinners", 12);
		vr.setWeight(50);
		assertEquals(120, vr.getWeight());
		vr.setWeight(120);
		assertEquals(120, vr.getWeight());
		vr.setWeight(130);
		assertEquals(130, vr.getWeight());

		assertEquals(12, vr.getNumberOfTracks());
		vr.setNumberOfTracks(0);
		assertEquals(0, vr.getNumberOfTracks());
	}
}
