package ch.yannic.warbuild.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ch.yannic.warbuild.PermissionYannic;
import ch.yannic.warbuild.command.EnderchestCommand;
import ch.yannic.warbuild.command.FlyCommand;
import ch.yannic.warbuild.command.GamemodeCommand;
import ch.yannic.warbuild.command.HealCommand;
import ch.yannic.warbuild.command.InvseeCommand;
import ch.yannic.warbuild.command.RepairCommand;
import ch.yannic.warbuild.command.SetSpawnCommand;
import ch.yannic.warbuild.command.SetWarpCommand;
import ch.yannic.warbuild.command.SpawnCommand;
import ch.yannic.warbuild.command.StackCommand;
import ch.yannic.warbuild.command.TeleportAllCommand;
import ch.yannic.warbuild.command.TeleportCommand;
import ch.yannic.warbuild.command.TeleportHereCommand;
import ch.yannic.warbuild.command.VanishCommand;
import ch.yannic.warbuild.listener.ChatPrefixListener;
import ch.yannic.warbuild.listener.JoinListener;
import ch.yannic.warbuild.listener.ProtectListener;

public class Main extends JavaPlugin {

	public static Main instance;

	private final String noperms = "§cDazu hast du keine Rechte!";

	private final String prefix = "§6War§eBuild §8│ ";

	public void onEnable() {
		instance = this;
		new PermissionYannic();
		registerCommands();
		registerListener();
		Bukkit.getConsoleSender().sendMessage("§ePlugin wurde gestartet!");
	}

	public void onDisable() {

	}

	public void registerCommands() {
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("teleport").setExecutor(new TeleportCommand());
		getCommand("teleporthere").setExecutor(new TeleportHereCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("teleportall").setExecutor(new TeleportAllCommand());
		getCommand("enderchest").setExecutor(new EnderchestCommand());
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("repair").setExecutor(new RepairCommand());
		getCommand("stack").setExecutor(new StackCommand());
		getCommand("setpermission").setExecutor(new PermissionYannic());
		/* getCommand("kit").setExecutor(new KitCommand()); */

	}

	public void registerListener() {

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new ChatPrefixListener(), this);
		pm.registerEvents(new ProtectListener(), this);
		/* pm.registerEvents(new KitListener(), this); */
		/* pm.registerEvents(new InvseeListener(), this); */
	}

	public static Main getInstance() {
		return instance;

	}

	public final String noperms() {
		return noperms;

	}

	public final String prefix() {
		return prefix;

	}
}
