/**
 * 
 */
package library_xml_resolver;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import library_xml_resolver.result.LibraryResult;
import library_xml_resolver.result.ResultError;
import library_xml_resolver.result.ResultVerified;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 * 
 * Create a valid path to the XML file.
 * 
 */
public class PathCreator {
	private final Logger LOGGER = LogManager.getLogger(PathCreator.class);
	
	private String path;	
	private String root;
	private String lib;
	private String ver;

	public PathCreator(PathData data) {
		if(data != null) {			
			root = data.getRoot();
			lib = data.getLibraryName();
			ver = data.getLibraryVersion();	
		}
	}

	public LibraryResult getVerifiedPath() {
		if(rootOk() && libraryOk() && versionOk()) {
			return new ResultVerified(path);
		}else {
			LOGGER.error("Path not verified!");
			return new ResultError();
		}
	}
	
	private boolean rootOk() {		
		if(root != null && new File(root).isDirectory()) {			
			path = root + "/";
			return true;
		}
		LOGGER.error(String.format("Invalid root dir [%s]!", root));
		return false;
	}
	
	private boolean libraryOk() {
		if(lib != null) {
			path += lib;
			if(new File(path).isDirectory()) {				
				path += "/";
				return true;
			}
		}
		LOGGER.error(String.format("Invalid library [%s] name!", lib));
		return false;
	}

	private boolean versionOk() {		
		if(ver != null) {
			checkForSymbol();
			replaceDotNotation();
			path += ver;
			if(new File(path).isDirectory()) {
				return true;
			}
		}
		LOGGER.error(String.format("Invalid version [%s] name!", ver));
		return false;
	}
	
	// All version dirs should start with lower case 'v'.
	private void checkForSymbol() {
		if(ver.charAt(0) != 'v') {
			if(ver.charAt(0) == 'V') {
				ver = "v" + ver.substring(1, ver.length()-1);
			}else {
				ver = "v" + ver;
			}	
		}		
	}

	private void replaceDotNotation() {
		ver = ver.replace(".", "_");		
	}
	
}
