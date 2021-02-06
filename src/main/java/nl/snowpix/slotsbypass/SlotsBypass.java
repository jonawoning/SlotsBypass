package nl.snowpix.slotsbypass;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlotsBypass extends JavaPlugin {

    public static SlotsBypass instance;
    public FileConfiguration c;
    public String Prefix;
    public String BypassPermission;
    public String Message_Format;
    public String Vip_Perm;
    public String Vip_Plus_Perm;
    public String Elite_Perm;
    public String Champion_Perm;
    public String Staff_Perm;
    public String Admin_Perm;
    public Integer VIP_Count;
    public Integer VIP_Plus_Count;
    public Integer Elite_Count;
    public Integer Champion_Count;
    public Integer Staff_Count;
    public boolean BypassMessage;
    public boolean Groups;

    @Override
    public void onEnable() {
        instance = this;
        c = getConfig();
        Prefix = ChatColor.translateAlternateColorCodes('&', instance.c.getString("Prefix"));
        BypassPermission = instance.c.getString("BypassPermission");
        Message_Format = ChatColor.translateAlternateColorCodes('&', instance.c.getString("Message_Format"));
        BypassMessage = instance.c.getBoolean("BypassMessage");
        Groups = instance.c.getBoolean("Groups");
        Vip_Perm = instance.c.getString("Vip_Perm");
        Vip_Plus_Perm = instance.c.getString("Vip+_Perm");
        Elite_Perm = instance.c.getString("Elite_Perm");
        Champion_Perm = instance.c.getString("Champion_Perm");
        Staff_Perm = instance.c.getString("Staff_Perm");
        Admin_Perm = instance.c.getString("Full_Bypass");
        VIP_Count = instance.c.getInt("VIP_Slots");
        VIP_Plus_Count = instance.c.getInt("VIP+_Slots");
        Elite_Count = instance.c.getInt("Elite_Slots");
        Champion_Count = instance.c.getInt("Champion_Slots");
        Staff_Count = instance.c.getInt("Staff_Slots");
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println(SystemColors.TEXT_YELLOW + "[BypassSlots]" + SystemColors.TEXT_GREEN + "The plugin is succesfully enabled." + SystemColors.TEXT_RESET);

    }

    @Override
    public void onDisable() {
        System.out.println(SystemColors.TEXT_YELLOW + "[BypassSlots]" + SystemColors.TEXT_GREEN + "The plugin is succesfully disabled." + SystemColors.TEXT_RESET);
    }

}
