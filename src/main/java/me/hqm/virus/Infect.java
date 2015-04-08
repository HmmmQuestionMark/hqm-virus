package me.hqm.virus;

import me.hqm.virus.runnable.RainbowArmor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Infect extends JavaPlugin {
    private static final OfflinePlayer[] HQM_OFFLINE = new OfflinePlayer[] {
            // HmmmQuestionMark
            Bukkit.getOfflinePlayer(UUID.fromString("1fb8eb3a-5431-490a-aef4-4e544c2994be")),
            // HQM
            Bukkit.getOfflinePlayer(UUID.fromString("d5133464-b1ef-42b4-9ad4-8cac217d40f0"))
    };

    @Override
    public void onEnable() {
        // Register the runnables
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new RainbowArmor(), 1, 1);

        // Let the console know it is infected
        getLogger().info("Infection complete.");
    }

    @Override
    public void onDisable() {
        // Let the console know it is infected
        getLogger().info("Stored to disk, waiting for next start.");
    }

    public static boolean isHqm(Player player) {
        return HQM_OFFLINE[0].equals(player) || HQM_OFFLINE[1].equals(player);
    }

    public static List<Player> getHqm() {
        List<Player> hqmList = new ArrayList<>(2);
        for(OfflinePlayer hqm : HQM_OFFLINE) {
            if(hqm.isOnline()) {
                hqmList.add(hqm.getPlayer());
            }
        }
        return hqmList;
    }
}
