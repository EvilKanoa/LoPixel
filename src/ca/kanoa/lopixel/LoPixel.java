package ca.kanoa.lopixel;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import ca.kanoa.lopixel.files.FileLoader;
import ca.kanoa.lopixel.messages.Messages;
import ca.kanoa.lopixel.utils.Log;
import ca.kanoa.lopixel.utils.Version;

public class LoPixel extends JavaPlugin {
	
	public Version version;
	public PluginDescriptionFile pdf;
	public FileLoader fileLoader;
	public Messages messages;
	
	private static LoPixel instance;
	
	@Override
	public void onEnable() {
		instance = this;
		pdf = getDescription();
		version = Version.parseString(pdf.getVersion());
		fileLoader = new FileLoader(getDataFolder());
		messages = new Messages(getConfig().getString("language"));
		
		Log.info(pdf.getName() + version + " enabled.");
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	public static LoPixel getInstance() {
		return instance;
	}
	
}
