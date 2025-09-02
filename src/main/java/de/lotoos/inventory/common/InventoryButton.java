package de.lotoos.inventory.common;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;

/**
 * @author hyperspace_pilot
 */
public abstract class InventoryButton {

    protected boolean cancelClick = true;
    protected Player player;

    public void click(Player player, InventoryAction inventoryAction) {
        this.player = player;
        onClick(inventoryAction);
    }

    public abstract void onAdd();

    public abstract void onClick(InventoryAction inventoryAction);

    public void setCancelClick(boolean cancelClick) {
        this.cancelClick = cancelClick;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isCancelClick() {
        return cancelClick;
    }
}
