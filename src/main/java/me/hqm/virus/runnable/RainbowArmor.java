package me.hqm.virus.runnable;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainbowArmor implements Runnable {
    private static final List<Color> BUKKIT_COLOR_ORDER = new ArrayList<>();
    private static Color COLOR;

    static {
        for (float i = 0F; i < 1F; i += 0.0027777777777778F) {
            java.awt.Color color = java.awt.Color.getHSBColor(i, 1F, 1F);
            BUKKIT_COLOR_ORDER.add(org.bukkit.Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue()));
        }
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            COLOR = null;
            ItemStack[] armorContents = player.getInventory().getArmorContents();
            Arrays.asList(armorContents).stream().filter(armor -> armor.getType().name().startsWith("LEATHER")).
                    forEach(armor -> {
                        LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
                        List<String> lore = meta.getLore();
                        if (!lore.isEmpty() && lore.get(0).toLowerCase().contains("gay")) {
                            if (COLOR == null) {
                                COLOR = getNextColor(meta.getColor());
                            }
                            meta.setColor(COLOR);
                            armor.setItemMeta(meta);
                        }
                    });
        });
    }

    public Color getNextColor(Color color) {
        int index = BUKKIT_COLOR_ORDER.indexOf(color);
        index = index == 359 ? 0 : index + 1;
        return BUKKIT_COLOR_ORDER.get(index);
    }
}
