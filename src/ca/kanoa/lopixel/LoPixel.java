package ca.kanoa.lopixel;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import ca.kanoa.lopixel.utils.Version;

public class LoPixel extends JavaPlugin {
	
	private static LoPixel instance;
	public Version version;
	public PluginDescriptionFile pdf;
	
	@Override
	public void onEnable() {
		instance = this;
		pdf = getDescription();
		version = Version.parseString(pdf.getVersion());
		
		//TODO: Switch this to using logging system
		System.out.println(pdf.getName() + version + " enabled.");
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	public static LoPixel getInstance() {
		return instance;
	}
	
}
