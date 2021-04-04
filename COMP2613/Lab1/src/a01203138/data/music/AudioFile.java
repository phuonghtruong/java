package a01203138.data.music;

import a01203138.data.MusicMedia;
import a01203138.io.FileManager;

public class AudioFile extends MusicMedia implements FileManager {

	private String fileName;
	private double fileSize;

	public AudioFile() {
		fileName = "unknown";
		fileSize = 0;
	}
	
	public AudioFile(String title, String artist, String fileName, double fileSize) {
		super(title, artist);
		setFileName(fileName);
		setFileSize(fileSize);
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		if (fileName != null && !fileName.isEmpty()) {
			this.fileName = fileName;
		} else {
			throw new IllegalArgumentException("fileName cannot be null or empty!");
		}
	}

	/**
	 * @return the fileSize
	 */
	public double getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(double fileSize) {
		if (fileSize >= 0) {
			this.fileSize = fileSize;
		} else {
			throw new IllegalArgumentException("fileSize cannot be negative!");
		}
	}

	@Override
	public void play() {
		System.out.println("Playing \"" +this.getFileName() +"\"." );
	}

	@Override
	public void delete(String path, String fileName) {
		System.out.println("Deleting " + fileName + 
				" from \"" + path + "\" folder.");
	}

	@Override
	public void save(String path, String fileName) {
		System.out.println("Saving " + fileName + 
				" to \"" + path + "\" folder.");

	}

	@Override
	public String toString() {
		return "AudioFile [fileName=" + fileName + ", fileSize=" + fileSize + 
				", toString()=" + super.toString() +"]";
	}

	
}
