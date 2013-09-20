package ca.kanoa.lopixel.files;

import java.util.HashMap;
import java.util.Map.Entry;

public class TextFile {

	private HashMap<String, String> data = new HashMap<String, String>();

	public void load(String file) {
		String[] lines = file.split("\n");
		StringBuilder builder;
		String key;
		String[] value;
		for (String s : lines) {
			if (s.contains(":")) {
				value = s.split(":");
				if (value.length < 2) {
					continue;
				}
				key = value[0];
				builder = new StringBuilder();
				for (int i = 1; i < value.length; i++) {
					builder.append(value[i]).append(' ');
				}
				data.put(key, builder.toString().trim());
			}
		}
		builder = null;
		key = null;
		value = null;
		lines = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Entry<String, String> entry : data.entrySet()) {
			builder.append(entry.getKey()).append(": ").
					append(entry.getValue().trim()).append("\n");
		}
		return builder.toString();
	}

	public String getValue(String key) {
		return data.get(key);
	}

	public void setValue(String key, String value) {
		data.put(key, value);
	}

}
