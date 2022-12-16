package ch14;

public class Address {
	private int zipCode;
	private String city;
	private String country;
	
	Address(int zipCode, String city, String country) {
		super();
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}
	
	
}
