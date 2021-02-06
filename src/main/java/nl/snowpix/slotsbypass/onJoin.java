package nl.snowpix.slotsbypass;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class onJoin implements Listener {

    @EventHandler
    public void OnPlayerLoginEvent(PlayerLoginEvent event){
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            Player player = event.getPlayer();
            if (SlotsBypass.instance.Groups){
                Integer online = Bukkit.getMaxPlayers();
                Integer players = Bukkit.getOnlinePlayers().size();
                Integer VIP = SlotsBypass.instance.VIP_Count + online;
                Integer VIP_Plus = SlotsBypass.instance.VIP_Plus_Count + online;
                Integer Elite = SlotsBypass.instance.Elite_Count + online;
                Integer Champion = SlotsBypass.instance.Champion_Count + online;
                Integer Staff = SlotsBypass.instance.Staff_Count + online;

                if (players <= VIP){
                    if (player.hasPermission(SlotsBypass.instance.Vip_Perm))
                        event.allow();
                }
                if (players <= VIP_Plus){
                    if (player.hasPermission(SlotsBypass.instance.Vip_Plus_Perm))
                        event.allow();
                }
                if (players <= Elite){
                    if (player.hasPermission(SlotsBypass.instance.Elite_Perm))
                        event.allow();
                }
                if (players <= Champion){
                    if (player.hasPermission(SlotsBypass.instance.Champion_Perm))
                        event.allow();
                }
                if (players <= Staff){
                    if (player.hasPermission(SlotsBypass.instance.Staff_Perm))
                        event.allow();
                }
                if (player.hasPermission(SlotsBypass.instance.Admin_Perm))
                    event.allow();
            }else{
                if (player.hasPermission(SlotsBypass.instance.BypassPermission)){
                    event.allow();
                }
            }
        }
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (SlotsBypass.instance.BypassMessage){
            if (Bukkit.getOnlinePlayers().size() > Bukkit.getServer().getMaxPlayers()){
                player.sendMessage(SlotsBypass.instance.Prefix + SlotsBypass.instance.Message_Format);
            }
        }
    }

}
