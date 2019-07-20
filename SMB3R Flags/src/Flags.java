import java.util.Random;

public class Flags {
	
	private String name;		//Flag name
	private String value;		//value used to calculate flags (base 36, replace O with !)
	private int rating;			//Randomness score (1-3)
	private int weight;			//% chance of this flag being enabled
	private boolean enabled;	//enabled flag
	private String choice;		//used for Level Appearance (? or hands) and for Permanent Mario Status
	
	public Flags(String name, String value, int rating, int weight) {
		this.name = name;
		this.value = value;
		this.rating = rating;
		this.weight = weight;
		this.enabled = false;
		this.choice = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getChoice() {
		return choice;
	}
	
	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	public String rollLevelAppearanceChoice() {
		boolean randBoolean = new Random().nextBoolean();
		
		if(randBoolean) {
			choice = "All ?";
			value = "27WR280";
		}
		else {
			choice = "All hands";
			value = "4FTI4G0";
		}
		
		return choice;
	}
	
	public String rollPermanentChoice() {
		int randInt = new Random().nextInt(15);
		
		//1 in 15 chance for Big Mario
		if(randInt == 0) {
			choice = "Big Mario";
			value = "4FTI4G";
		}
		
		//2 in 15 chance for Raccoon Mario
		else if(randInt <= 2) {
			choice = "Raccoon Mario";
			value = "8VN08W";
		}
		
		//3 in 15 chance for all other forms
		else if(randInt <= 5) {
			choice = "Fire Mario";
			value = "6NQ96O";
		}
		else if(randInt <= 8) {
			choice = "Frog Mario";
			value = "B3JRB4";
		}
		else if(randInt <= 11) {
			choice = "Tanooki Mario";
			value = "DBGIDC";
		}
		else {
			choice = "Hammer Mario";
			value = "FJD9FK";
		}
		
		return choice;
	}
	
	public boolean rollEnabled() {
		int randomInt = new Random().nextInt(101);
		//System.out.println(randomInt);
		
		if(randomInt <= weight)
			enabled = true;
		else
			enabled = false;
		
		return enabled;
			
	}
	
	@Override
	public String toString() {
		String s = "Flags [" + name + ", " + enabled;
		if(! choice.isEmpty())
			s += ", " + choice;
		s += "]";
		
		return s;
	}
}
