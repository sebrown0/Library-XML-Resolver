/**
 * 
 */
package library_xml_resolver.result;

import java.util.Optional;

/**
 * @author SteveBrown
 * @since 1.0
 */
public class ResultVerified implements LibraryResult {
	private String path;
		
	public ResultVerified(String path) {
		this.path = path;
	}

	@Override
	public Optional<String> getPath() {		
		return Optional.of(path);
	}

}
