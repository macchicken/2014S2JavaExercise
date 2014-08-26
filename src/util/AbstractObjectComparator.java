package util;

import java.util.Comparator;

public abstract class AbstractObjectComparator implements Comparator<Object> {
	
	protected String key;

	public String getKey() {
		return key;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}
	
	public void setKey(String key) {
		this.key = key;
	}


}
