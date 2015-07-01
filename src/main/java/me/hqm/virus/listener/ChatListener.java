package me.hqm.virus.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().
                replace("p4p", "buttsex").
                replace("P4P", "buttsex").
                replace("p4P", "buttsex").
                replace("P4p", "buttsex");
        event.setMessage(message);
    }
}
