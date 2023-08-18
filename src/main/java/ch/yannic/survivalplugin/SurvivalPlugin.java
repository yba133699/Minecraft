package ch.yannic.survivalplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalPlugin extends JavaPlugin {

    public static SurvivalPlugin instance;

    private final String prefix = "§6System §8• ";

    private final String noperms = prefix + "§cDazu hast du keine Rechte!";

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Hello!");
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        this.getCommand("enderchest").setExecutor(new EnderchestCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("god").setExecutor(new GodCommand());
        this.getCommand("tp").setExecutor(new TeleportCommand());
        this.getCommand("gm").setExecutor(new GamemodeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SurvivalPlugin getInstance() {
        return instance;
    }
    public String prefix() {
        return prefix;
    }
    public String noperms() {
        return noperms;
    }


}
