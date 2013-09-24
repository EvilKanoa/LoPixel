package ca.kanoa.lopixel.sql;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
	
	private List<Row> data;
	
	public Table() {
		data = new ArrayList<Row>();
	}
	
	public Row getRow(int row) {
		return data.get(row);
	}
	
	public void sort() {
		Collections.sort(data, new TableSorter());
	}
	
}
