package ca.kanoa.lopixel.messages;

import java.io.File;

import ca.kanoa.lopixel.LoPixel;
import ca.kanoa.lopixel.files.FileLoader;
import ca.kanoa.lopixel.files.TextFile;

public class Messages {
	
	private final TextFile languageFile;
	private final String language;
	
	public Messages(String language) {
		this.language = language;
		languageFile = LoPixel.getInstance().fileLoader.loadTextFile("messages" + 
				File.separator + language + ".txt");
	}
	
	public Messages(String language, FileLoader loader) {
		this.language = language;
		languageFile = loader.loadTextFile("messages" + 
				File.separator + language + ".txt");
	}

	public String getMessage(String message) {
		return languageFile.getValue(message);
	}
	
	public String getMessageNumbered(String message, String... arguments) {
		String string = languageFile.getValue(message);
		for (int i = 0; i < arguments.length; i++)
			string.replace(String.format("%s%s%s", "%ARG", i, "%"), arguments[i]);
		return string;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String format(String message, String constent, String variable) {
		message = languageFile.getValue(message);
		return message.replace(String.format("%s%s%s", "%", constent.toUpperCase(), 
				"%"), variable);
	}
	
	public String format(String message, String[] constents, String[] variables) {
		message = languageFile.getValue(message);
		int i = 0;
		
		while (i < constents.length && i < variables.length) {
			message = message.replace("%" + constents[i].toUpperCase() + "%", variables[i]);
			i++;
		}
		return message;
	}
	
}
