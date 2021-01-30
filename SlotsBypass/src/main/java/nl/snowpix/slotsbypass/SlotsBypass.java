package nl.snowpix.slotsbypass;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlotsBypass extends JavaPlugin {

    public static SlotsBypass instance;
    public FileConfiguration c;
    public String Prefix;
    public String BypassPermission;
    public String Message_Format;
    public boolean BypassMessage;

    @Override
    public void onEnable() {
        instance = this;
        c = getConfig();
        Prefix = instance.c.getString("Prefix");
        BypassPermission = instance.c.getString("BypassPermission");
        Message_Format = instance.c.getString("Message_Format");
        BypassMessage = instance.c.getBoolean("BypassMessage");
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("[BypassSlots] The plugin is succesfully enabled.");

    }

    @Override
    public void onDisable() {
        System.out.println("[BypassSlots] The plugin is succesfully disabled.");
    }

}
