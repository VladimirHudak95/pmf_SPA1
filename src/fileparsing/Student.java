package fileparsing;

public class Student {
	
	private String firstName, lastName;
	private int yearOfBirth;
	
	public Student(String lastName, String firstName, int yearOfBirth) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.yearOfBirth = yearOfBirth;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " rodjen/a " + yearOfBirth;
	}
	
	
}
