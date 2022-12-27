package ch.yannic.spigotmc.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ch.yannic.spigotmc.command.HealCommand;

public class Main extends JavaPlugin {

	public static Main instance;
	
	public static String prefix;
	
	public static String consoleusage;
	
	public static String healedfromconsole;
	
	public static String notonline;
	
	public static String healperms;
	
	public static String healotherperms;
	
	public static String noperms;
	
	public static String usage;
	
	public static String selfmessage;
	
	public static String targetmessage;
	
	public static String playermessage;
	
	public void onEnable() {
		instance = this;
		loadConfig();
		loadStrings();
		registerCommands();
		Bukkit.getConsoleSender().sendMessage("§6Plugin wurde gestartet!");
	}
	
	public void loadConfig() {
		FileConfiguration config = getConfig();
		config.addDefault("Config.Prefix", "&6Heal &8| ");
		config.addDefault("Config.Permission Heal", "command.heal");
		config.addDefault("Config.Permission Heal Other", "command.heal.other");
		config.addDefault("Config.No Permission", "&cDazu hast du keine Rechte!");
		config.addDefault("Config.Usage", "&7Bitte nutze &c/heal (SPIELER)");
		config.addDefault("Config.Konsole Usage", "&cAls Konsole kannst nur andere Spieler heilen!");
		config.addDefault("Config.Not Online", "&6(argument) &cist nicht Online!");
		config.addDefault("Config.Message1", "&7Du wurdest von &aCONSOLE &7geheilt!");
		config.addDefault("Config.Message2", "&7Du hast &6(TARGET) &7geheilt!");
		config.addDefault("Config.Message3", "&7Du wurdest geheilt!");
		config.addDefault("Config.Message4", "&7Du wurdest von (PLAYER) geheilt!");
		
		config.options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}
	
	public void loadStrings() {
		FileConfiguration config = getConfig();
		prefix = config.getString("Config.Prefix").replaceAll("&", "§");
		healperms = config.getString("Config.Permission Heal").replaceAll("&", "§");
		healotherperms = config.getString("Config.Permission Heal Other").replaceAll("&", "§");
		noperms = config.getString("Config.No Permission").replaceAll("&", "§");
		usage = config.getString("Config.Usage").replaceAll("&", "§");
		consoleusage = config.getString("Config.Konsole Usage").replaceAll("&", "§");
		notonline = config.getString("Config.Not Online").replaceAll("&", "§");
		healedfromconsole = config.getString("Config.Message1").replaceAll("&", "§");
		playermessage = config.getString("Config.Message2").replaceAll("&", "§");
		selfmessage = config.getString("Config.Message3").replaceAll("&", "§");
		targetmessage = config.getString("Config.Message4").replaceAll("&", "§");
	}
	
	public void registerCommands() {
		getCommand("heal").setExecutor(new HealCommand());
	}
	
	public static Main getInstance() {
		return instance;
	}
}
