/**
 * 
 */
package library_xml_resolver.result;

import java.util.Optional;

/**
 * @author SteveBrown 
 * @since 1.0
 * 
 * The result of checking for a library. 
 */
public interface LibraryResult {
	Optional<String> getPath();
}
