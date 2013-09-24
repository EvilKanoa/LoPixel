package ca.kanoa.lopixel.sql;

public class Row {
	
	private int primaryKey;
	private Object[] data;
	
	public Row(Object[] data, int primaryKey) {
		if (primaryKey < data.length) {
			this.primaryKey = -1;
		}
		this.data = data;
	}
	
	public Row(Object[] data) {
		this.primaryKey = -1;
		this.data = data;
	}
	
	public Object getKey() {
		return primaryKey == -1 ? null : data[primaryKey];
	}
	
}
