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
                int maxPlayers = Bukkit.getMaxPlayers();
                int onlinePlayers = Bukkit.getOnlinePlayers().size();
                int VIP = SlotsBypass.instance.VIP_Count + maxPlayers;
                int VIP_Plus = SlotsBypass.instance.VIP_Plus_Count + maxPlayers;
                int Elite = SlotsBypass.instance.Elite_Count + maxPlayers;
                int Champion = SlotsBypass.instance.Champion_Count + maxPlayers;
                int Staff = SlotsBypass.instance.Staff_Count + maxPlayers;

                if (player.hasPermission(SlotsBypass.instance.Admin_Perm)){
                    event.allow();
                    return;
                }

                if (onlinePlayers <= VIP){
                    if (player.hasPermission(SlotsBypass.instance.Vip_Perm)){
                        event.allow();
                        return;
                    }
                }
                if (onlinePlayers <= VIP_Plus){
                    if (player.hasPermission(SlotsBypass.instance.Vip_Plus_Perm)){
                        event.allow();
                        return;
                    }
                }
                if (onlinePlayers <= Elite){
                    if (player.hasPermission(SlotsBypass.instance.Elite_Perm)){
                        event.allow();
                        return;
                    }
                }
                if (onlinePlayers <= Champion){
                    if (player.hasPermission(SlotsBypass.instance.Champion_Perm)){
                        event.allow();
                        return;
                    }
                }
                if (onlinePlayers <= Staff){
                    if (player.hasPermission(SlotsBypass.instance.Staff_Perm)){
                        event.allow();
                    }
                }
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
