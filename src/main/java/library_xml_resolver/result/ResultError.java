/**
 * 
 */
package library_xml_resolver.result;

import java.util.Optional;

/**
 * @author SteveBrown
 * @since 1.0
 */
public class ResultError implements LibraryResult {
	
	@Override
	public Optional<String> getPath() {		
		return Optional.empty();
	}

}
