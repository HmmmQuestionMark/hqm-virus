package me.hqm.virus;

import me.hqm.virus.command.RainbowArmorCommand;
import me.hqm.virus.listener.ChatListener;
import me.hqm.virus.runnable.RainbowArmor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Infect extends JavaPlugin {
    private static final UUID[] HQM_OFFLINE = new UUID[] {
            // HmmmQuestionMark
            UUID.fromString("1fb8eb3a-5431-490a-aef4-4e544c2994be"),
            // HQM
            UUID.fromString("d5133464-b1ef-42b4-9ad4-8cac217d40f0"),
            // HandyQuestMarker
            UUID.fromString("cfb58ffa-b6e8-4810-a08e-2e46feaaf2ec")
    };

    @Override
    public void onEnable() {
        // Register the runnables
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new RainbowArmor(), 1, 1);

        // Register the commands
        getCommand("rainbowarmor").setExecutor(new RainbowArmorCommand());

        // Register the listeners
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new ChatListener(), this);

        // Let the console know it is infected
        getLogger().info("Infection complete.");
    }

    @Override
    public void onDisable() {
        // Let the console know it is infected
        getLogger().info("Stored to disk, waiting for next start.");
    }

    public static boolean isHqm(Player player) {
        return HQM_OFFLINE[0].equals(player.getUniqueId()) || HQM_OFFLINE[1].equals(player.getUniqueId());
    }

    public static List<Player> getHqm() {
        List<Player> hqmList = new ArrayList<>(2);
        for(UUID hqmId : HQM_OFFLINE) {
            OfflinePlayer hqm = Bukkit.getOfflinePlayer(hqmId);
            if(hqm.isOnline()) {
                hqmList.add(hqm.getPlayer());
            }
        }
        return hqmList;
    }
}
