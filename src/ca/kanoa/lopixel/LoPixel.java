package ca.kanoa.lopixel;

import java.io.File;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import ca.kanoa.lopixel.files.FileLoader;
import ca.kanoa.lopixel.gamemodes.Gamemode;
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
		saveDefaultConfig();
		if (!(new File(getDataFolder(), "messages" + File.separator + 
				"english.txt").exists())) {
			saveResource("messages/english.txt", false);
		}
		
		pdf = getDescription();
		version = Version.parseString(pdf.getVersion());
		fileLoader = new FileLoader(getDataFolder());
		messages = new Messages(getConfig().getString("language"));
		
		Log.info(messages.format("plugin-enabled", new String[]{"name",  "version"}, 
				new String[]{pdf.getName(), version.toString()}));
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	public static LoPixel getInstance() {
		return instance;
	}
	
	public static Messages getMessages() {
		return instance.messages;
	}
	
	public static Messages getMessages(JavaPlugin plugin) {
		if (plugin.getClass().getAnnotation(Gamemode.class) != null) {
			return new Messages(instance.getConfig().getString("language"), 
					new FileLoader(plugin.getDataFolder()));
		} else {
			return instance.messages;
		}
	}
	
}
