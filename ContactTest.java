import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		assertTrue(contactClass.getContactID().equals("123"));
		assertTrue(contactClass.getFirstName().equals("Brian"));
		assertTrue(contactClass.getLastName().equals("Golden"));
		assertTrue(contactClass.getPhone().equals("1234567890"));
		assertTrue(contactClass.getAddress().equals("12 Hello ST Nowhere, NY"));
	}

	@Test
	void testContactIDToLong() { // ContactID has 15 Chars here
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789123456", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactFirstNameToLong() { // First name has 14 chars here
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Briannnnnnnnnn", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", null, "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactLastNameToLong() { // Last name has 11 chars here
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", "Goldennnnnn", "1234567890", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", null, "1234567890", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactNumberLessThan10() { // phone number is 9 chars here
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", "Golden", "123456789", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactNumberMoreThan10() {// phone number is 11 chars here
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", "Golden", "12345678900", "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", "Golden", null, "12 Hello ST Nowhere, NY");
		});
	}

	@Test
	void testContactAddressToLong() { // address is 32 chars here
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY 12345678");
		});
	}

	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Brian", "Golden", "1234567890", null);
		});
	}

	@Test
	void testContactClassUpdateFirstName() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		assertTrue(contactClass.getFirstName().equals("Brian"));
		contactClass.setFirstName("Bob");
		assertTrue(contactClass.getFirstName().equals("Bob"));
	}

	@Test
	void testContactClassBadUpdateFirstName() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setFirstName("TooManyChars");
		});
	}

	@Test
	void testContactClassUpdateLasttName() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		assertTrue(contactClass.getLastName().equals("Golden"));
		contactClass.setLastName("NewName");
		assertTrue(contactClass.getLastName().equals("NewName"));
	}

	@Test
	void testContactClassBadUpdateLastName() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setLastName("TooManyChars");
		});
	}
	
	@Test
	void testContactClassUpdatePhone() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		assertTrue(contactClass.getPhone().equals("1234567890"));
		contactClass.setPhone("9876543210");
		assertTrue(contactClass.getPhone().equals("9876543210"));
	}
	
	@Test
	void testContactClassBadUpdatePhone() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setPhone("123456");
		});
	}

	@Test
	void testContactClassUpdateAddress() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		assertTrue(contactClass.getAddress().equals("12 Hello ST Nowhere, NY"));
		contactClass.setAddress("22 Bye Ave Somewhere, NY");
		assertTrue(contactClass.getAddress().equals("22 Bye Ave Somewhere, NY"));
	}
	@Test
	void testContactClassBadUpdateAddress() {
		Contact contactClass = new Contact("123", "Brian", "Golden", "1234567890", "12 Hello ST Nowhere, NY");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setAddress("12 This is going to be way more that 30 characters and will fail");
		});
	}
}
