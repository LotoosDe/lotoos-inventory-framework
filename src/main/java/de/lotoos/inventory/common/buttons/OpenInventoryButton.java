package de.lotoos.inventory.common.buttons;

import de.lotoos.inventory.InventoryFramework;
import de.lotoos.inventory.InventoryManager;
import de.lotoos.inventory.common.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;

/**
 * @author hyperspace_pilot
 */
public class OpenInventoryButton extends Button {

    protected InventoryManager inventoryManager;
    protected Inventory inventory;
    protected Player player;

    public OpenInventoryButton(InventoryManager inventoryManager, Inventory inventory, Player player) {
        this.inventoryManager = inventoryManager;
        this.inventory = inventory;
        this.player = player;
    }

    @Override
    public void onClick(InventoryAction inventoryAction) {
        InventoryFramework.getInventoryFramework().createInventoryBuilder(this.inventoryManager).buildInventory(inventory);
    }
}