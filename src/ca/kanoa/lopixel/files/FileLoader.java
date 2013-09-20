package ca.kanoa.lopixel.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ca.kanoa.lopixel.utils.Log;

public class FileLoader {
	
	private final File root;
	
	public FileLoader(File root) {
		if (root.isDirectory()) {
			this.root = root;
		} else {
			this.root = new File(".");
		}
	}
	
	public TextFile loadTextFile(String fileName) {
		File file = new File(root, fileName);
		TextFile textFile = new TextFile();
		if (file.isDirectory()) {
			return textFile;
		}
		
		StringBuilder fileText = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String s;
			while ((s = reader.readLine()) != null) {
				fileText.append(s).append("\n");
			}
		} catch (FileNotFoundException e) {
			Log.warning("Could not find file: " + file.getName());
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("Could not read file: " + file.getName());
		} finally {
			try {
				if (reader != null)
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		textFile.load(fileText.toString().substring(0, fileText.toString().length() - 2));
		return textFile;
	}
	
}
