package de.lotoos.inventory.common.buttons;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

/**
 * @author hyperspace_pilot
 */
public abstract class FetchChatMessageButton extends Button implements Listener {

    private Plugin plugin;
    protected Player player;

    public FetchChatMessageButton(Plugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    public void onClick(InventoryAction inventoryAction) {
        player.closeInventory();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (event.getPlayer().getUniqueId().equals(player.getUniqueId())) {
            onReceiveMessage(event.getMessage());
            event.setCancelled(true);
            HandlerList.unregisterAll(this);
        }
    }

    public abstract void onReceiveMessage(String message);
}