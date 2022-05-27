package library_xml_resolver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibarryResolver_Tests {

	@Test
	void resolver_isNotNull() {
		LibraryData data = new LibraryData(); 
		assertTrue(data != null);
	}

	@Test
	void resolverAttributes() {
		LibraryData data = new LibraryData();
		data.setRoot("").setLibrary("").setVersion("");
	}
}
