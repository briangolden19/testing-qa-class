import java.util.Hashtable;

public class ContactService {
	private Hashtable<String, Contact> contactList;

	public ContactService() {
		contactList = new Hashtable<String, Contact>();
	}

	public void addContact(Contact con) {
		if (contactList.get(con.getContactID()) != null) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contactList.put(con.getContactID(), con);
	}

	public void removeContact(String contactID) {
		if (contactList.get(contactID) == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contactList.remove(contactID);
	}

	public Contact getContact(String contactID) {
		return contactList.get(contactID);
	}

	public void updateFirstName(String contactID, String firstName) {
		if (contactList.get(contactID) == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contactList.get(contactID).setFirstName(firstName);
	}

	public void updateLastName(String contactID, String lastName) {
		if (contactList.get(contactID) == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contactList.get(contactID).setLastName(lastName);
	}

	public void updatePhone(String contactID, String phone) {
		if (contactList.get(contactID) == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contactList.get(contactID).setPhone(phone);
	}

	public void updateAddress(String contactID, String address) {
		if (contactList.get(contactID) == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contactList.get(contactID).setAddress(address);
	}
}
