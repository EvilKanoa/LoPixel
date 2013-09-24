package ca.kanoa.lopixel.utils;

import java.util.logging.Level;

import org.bukkit.Bukkit;

public class Log {
	
	public static void stats(String message) {
		log(message, Level.FINE);
	}
	
	public static void info(String message) {
		log(message, Level.INFO);
	}
	
	public static void warning(String message) {
		log(message, Level.WARNING);
	}
	
	public static void error(String message) {
		log(message, Level.SEVERE);
	}
	
	private static void log(String message, Level level) {
		Bukkit.getLogger().log(level, message);
	}
	
}
