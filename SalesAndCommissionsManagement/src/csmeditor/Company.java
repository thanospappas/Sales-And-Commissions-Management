package csmeditor;

public class Company {

	private String name;
	private Address address;

	public Company() {
		address = new Address();
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}	
}
