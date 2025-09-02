package de.lotoos.inventory.common;

import de.lotoos.inventory.common.items.ItemData;

/**
 * @author hyperspace_pilot
 */
public abstract class InventoryDesign {

    protected ItemData[][] items;
    protected int rows;
    protected boolean animated;

    public InventoryDesign(int rows) {
        this.rows = (rows <= 0 ? 1 : (rows > 6 ? 6 : rows));
        this.items = new ItemData[rows][9];
    }

    public abstract void registerItems();

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getRows() {
        return rows;
    }

    public ItemData[][] getItems() {
        return items;
    }

    public boolean isAnimated() {
        return animated;
    }
}
