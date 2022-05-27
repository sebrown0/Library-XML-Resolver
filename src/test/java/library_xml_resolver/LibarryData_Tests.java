package library_xml_resolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LibarryData_Tests {

	@Test
	void isNotNull() {
		LibraryData data = new LibraryData(); 
		assertTrue(data != null);
	}

	@Test
	void dataAttributes() {
		LibraryData data = new LibraryData();
		data.setRoot("root").setLibrary("lib").setVersion("1.0.0");
		assertEquals("root", data.getRoot());
		assertEquals("lib", data.getLibraryName());
		assertEquals("1.0.0", data.getLibraryVersion());
	}
	
	@Test
	void valid_pathToFile() {
		PathVerifier data = 
			new LibraryData()
				.setRoot("./src/test/resources/libraries") 
				.setLibrary("dakar")
				.setVersion("1.0.0");
		
		assertEquals("./src/test/resources/libraries/dakar/v1_0_0", data.getVerifiedPath().getPath().get());
	}
	
	@Test
	void invalid_pathToFile() {
		PathVerifier data = 
			new LibraryData()
				.setRoot("./src/test/resources/libraries") 
				.setLibrary("XXXX")
				.setVersion("x.x.x");
		
		assertTrue(data.getVerifiedPath().getPath().isEmpty());		
	}
}
