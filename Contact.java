
public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Contact(String ID, String fn, String ln, String ph, String add) {
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("ID does not meet requirements.");
		}
		if (fn == null || fn.length() > 10) {
			throw new IllegalArgumentException("firstName does not meet requirements.");
		}
		if (ln == null || ln.length() > 10) {
			throw new IllegalArgumentException("lastName does not meet requirements.");
		}
		if (ph == null || ph.length() != 10) {
			throw new IllegalArgumentException("Phone nmumber does not meet requirements.");
		}
		if (add == null || add.length() > 30) {
			throw new IllegalArgumentException("Address does not meet requirements.");
		}
		contactID = ID;
		firstName = fn;
		lastName = ln;
		phone = ph;
		address = add;
	}

	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("FirstName does not meet requirements.");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("LastName does not meet requirements.");
		}
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone number does not meet requirements.");
		}
		this.phone = phone;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address does not meet requirements.");
		}
		this.address = address;
	}
}
