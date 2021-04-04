package a01203138.data;

public abstract class MusicMedia {

	private String title;
	private String artist;

	public MusicMedia() {
		title = "unknown";
		artist = "unknown";
	}

	public MusicMedia(String title, String artist) {
		super();
		setTitle(title);
		setArtist(artist);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
		} else {
			throw new IllegalArgumentException("Title cannot be null or empty!");
		}
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		if (artist != null && !artist.isEmpty()) {
			this.artist = artist;
		} else {
			throw new IllegalArgumentException("Artist cannot be null or empty!");
		}
	}

	@Override
	public String toString() {
		return "MusicMedia [title=" + title + ", artist=" + artist + "]";
	}

	public abstract void play();

}
