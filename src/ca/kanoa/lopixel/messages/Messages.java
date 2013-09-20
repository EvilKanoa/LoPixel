package ca.kanoa.lopixel.messages;

import java.io.File;

import ca.kanoa.lopixel.LoPixel;
import ca.kanoa.lopixel.files.TextFile;

public class Messages {
	
	private final TextFile languageFile;
	private final String language;
	
	public Messages(String language) {
		this.language = language;
		languageFile = LoPixel.getInstance().fileLoader.loadTextFile("messages" + 
				File.separator + language + ".txt");
	}

	public String getMessage(String message) {
		return languageFile.getValue(message);
	}
	
	public String getLanguage() {
		return language;
	}
	
}
