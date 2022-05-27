/**
 * 
 */
package library_xml_resolver;

import library_xml_resolver.result.LibraryResult;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 */
public class LibraryData implements PathData, PathVerifier {
	private String root;
	private String libraryName;
	private String libraryVersion;
	
	public LibraryData setRoot(String root) {
		this.root = root;
		return this;
	}
	public LibraryData setLibrary(String libraryName) {
		this.libraryName = libraryName;
		return this;
	}
	public LibraryData setVersion(String libraryVersion) {
		this.libraryVersion = libraryVersion;
		return this;
	}

	@Override
	public String getRoot() {
		return root;
	}
	@Override
	public String getLibraryName() {
		return libraryName;
	}
	@Override
	public String getLibraryVersion() {
		return libraryVersion;
	}
	
	@Override
	public LibraryResult getVerifiedPath() {
		return new PathCreator(this).getVerifiedPath();
	}

}
