package de.lotoos.inventory;

import de.lotoos.inventory.common.InventoryBuilder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryFramework extends JavaPlugin {

    private static InventoryFramework inventoryFramework;
    private InventoryManager inventoryManager;

    @Override
    public void onLoad() {
        inventoryFramework = this;
    }

    @Override
    public void onEnable() {
        this.inventoryManager = createInventoryManager(this);
    }

    public InventoryManager createInventoryManager(Plugin plugin) {
        return new InventoryManager(plugin);
    }

    public InventoryBuilder createInventoryBuilder(InventoryManager inventoryManager) {
        return new InventoryBuilder(inventoryManager);
    }

    public static InventoryFramework getInventoryFramework() {
        return inventoryFramework;
    }

    public static InventoryFramework get() {
        return inventoryFramework;
    }

    public static void setInventoryFramework(InventoryFramework inventoryFramework) {
        InventoryFramework.inventoryFramework = inventoryFramework;
    }
}