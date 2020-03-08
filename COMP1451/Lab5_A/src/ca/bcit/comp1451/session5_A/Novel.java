/**
 * 
 */
package ca.bcit.comp1451.session5_A;

/**
 * @author A01203138
 *
 */
public class Novel extends ReadingMaterial {

	/**
	 * 
	 */
	private String mainCharacterName;
	private String theme;
	private String novelistName;
	
	public Novel(String title, int numberOfPages, String mainCharacterName,
			String theme, String novelistName) {
		// TODO Auto-generated constructor stub
		super(title,numberOfPages);
		setMainCharacterName(mainCharacterName);
		setTheme(theme);
		setNovelistName(novelistName);
	}
	
	public void setMainCharacterName(String mainCharacterName) {
		if(mainCharacterName == null || mainCharacterName.isBlank() || mainCharacterName.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty string");
		}
		else {
			this.mainCharacterName = mainCharacterName;
		}
	}
	
	public String getMainCharacterName() {return mainCharacterName;}
	
	public void setTheme(String theme) {
		if(theme == null || theme.isBlank() || theme.isEmpty()) {
			throw new IllegalArgumentException("theme cannot be null or empty string");
		}
		else {
			this.theme = theme;
		}
	}
	
	public String getTheme() {return theme;}
	
	public void setNovelistName(String novelistName) {
		if(novelistName == null || novelistName.isBlank() || novelistName.isEmpty()) {
			throw new IllegalArgumentException("novelist name cannot be null or empty string");
		}
		else {
			this.novelistName = novelistName;
		}
	}
	
	public String getNovelistName() {return novelistName;}
	
	public void displayDetails() {
		System.out.println("title: " + getTitle());
		System.out.println("Main character name: " + getMainCharacterName());
		System.out.println("Theme: " + getTheme());
		System.out.println("Novelist Name: " + getNovelistName());
	}

}
