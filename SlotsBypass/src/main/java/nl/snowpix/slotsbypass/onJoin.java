package nl.snowpix.slotsbypass;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class onJoin implements Listener {

    @EventHandler
    public void OnPlayerLoginEvent(PlayerLoginEvent event){
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            Player player = event.getPlayer();
            if (player.hasPermission(SlotsBypass.instance.BypassPermission))
                event.allow();
                if (SlotsBypass.instance.BypassMessage){
                    player.sendMessage(SlotsBypass.instance.Prefix + SlotsBypass.instance.Message_Format);
                }
        }
    }

}
