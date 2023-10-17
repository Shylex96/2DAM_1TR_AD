package exercises;

import java.io.File;
import java.io.FilenameFilter;

public class Filtro implements FilenameFilter {
	
	String filter;

	public Filtro(String filter) {
		this.filter = filter;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.startsWith(filter);
	}

}
