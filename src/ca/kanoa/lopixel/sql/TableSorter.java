package ca.kanoa.lopixel.sql;

import java.util.Comparator;

public class TableSorter implements Comparator<Row> {

	@Override
	public int compare(Row row1, Row row2) {
		if (row1.getKey() instanceof Integer && row2.getKey() instanceof Integer) {
			int key1 = (Integer) row1.getKey();
			int key2 = (Integer) row2.getKey();
			if (key1 > key2) {
				return 1;
			} else if (key2 > key1) {
				return -1;
			} else {
				return 0;
			}
		}
		return 0;
	}

}
