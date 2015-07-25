package me.hqm.virus.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ChatListener implements Listener {
    private static Map<String, String> REPLACEMENTS = new HashMap<>();

    static {
        // p4p -> Kappa
        REPLACEMENTS.put("p4p", "Kappa");

        // Nablu -> Spammer
        REPLACEMENTS.put("Nablu", "Spammer");

        // lag -> swag
        REPLACEMENTS.put("lag", "swag");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        for (Map.Entry<String, String> entry : REPLACEMENTS.entrySet()) {
            message = message.replaceAll("(?i)" + Pattern.quote(entry.getKey()), entry.getValue());
        }
        event.setMessage(message);
    }
}
