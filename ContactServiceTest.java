import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testContactServiceAddContact() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		assertTrue(contactServiceClass.getContact("123") != null);
		assertTrue(contactServiceClass.getContact("123").getFirstName().equals("Brian"));
	}

	@Test
	void testContactServiceAddDupeContactID() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass
					.addContact(new Contact("123", "New", "Person", "0123456789", "18 Hello ST Nowhere, NY"));
		});
	}

	@Test
	void testContactServiceRemoveContact() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		assertTrue(contactServiceClass.getContact("123") != null);
		contactServiceClass.removeContact("123");
		assertTrue(contactServiceClass.getContact("123") == null);
	}

	@Test
	void testContactServiceRemoveNonexistantContact() {
		ContactService contactServiceClass = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.removeContact("123");
		});
	}

	@Test
	void testContactServiceUpdateFirstName() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		assertTrue(contactServiceClass.getContact("123").getFirstName().equals("Brian"));
		contactServiceClass.updateFirstName("123", "NewName");
		assertTrue(contactServiceClass.getContact("123").getFirstName().equals("NewName"));
	}

	@Test
	void testContactServiceUpdateBadFirstName() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updateFirstName("123", null);
		});
	}

	@Test
	void testContactServiceUpdateFirstNameNullContact() {
		ContactService contactServiceClass = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updateFirstName("123", "Brian");
		});
	}

	@Test
	void testContactServiceUpdateLastName() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		assertTrue(contactServiceClass.getContact("123").getLastName().equals("Golden"));
		contactServiceClass.updateLastName("123", "NewName");
		assertTrue(contactServiceClass.getContact("123").getLastName().equals("NewName"));
	}

	@Test
	void testContactServiceUpdateBadLastName() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updateLastName("123", null);
		});
	}
	
	@Test
	void testContactServiceUpdateLastNameNullContact() {
		ContactService contactServiceClass = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updateLastName("123", "Golden");
		});
	}

	@Test
	void testContactServiceUpdatePhone() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		assertTrue(contactServiceClass.getContact("123").getPhone().equals("1234567890"));
		contactServiceClass.updatePhone("123", "9876543210");
		assertTrue(contactServiceClass.getContact("123").getPhone().equals("9876543210"));
	}

	@Test
	void testContactServiceUpdateBadPhone() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updatePhone("123", null);
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneNullContact() {
		ContactService contactServiceClass = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updatePhone("123", "1234567890");
		});
	}

	@Test
	void testContactServiceUpdateAddress() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		assertTrue(contactServiceClass.getContact("123").getAddress().equals("12 Hello ST Nowhere, NY"));
		contactServiceClass.updateAddress("123", "22 Bye Ave Somewhere, NY");
		assertTrue(contactServiceClass.getContact("123").getAddress().equals("22 Bye Ave Somewhere, NY"));
	}

	@Test
	void testContactServiceUpdateBadAddress() {
		ContactService contactServiceClass = new ContactService();
		contactServiceClass.addContact(new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updateAddress("123", null);
		});
	}
	
	@Test
	void testContactServiceUpdateAddressNullContact() {
		ContactService contactServiceClass = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactServiceClass.updateAddress("123", "22 Somewhere ST, Nope NY");
		});
	}

}
