package objects;

public class UserDetails {
	
	private String name;
	private String gender;
	private String country;
	
	public UserDetails(String name,String country,String gender) {
		this.name = name;
		this.gender = gender;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
