package de.lotoos.inventory.common.designs;

import de.lotoos.inventory.common.InventoryDesign;
import de.lotoos.inventory.common.items.ItemData;

/**
 * @author hyperspace_pilot
 */
public class CleanBackGroundDesign extends InventoryDesign {

    protected ItemData backGroundItem;

    public CleanBackGroundDesign(int rows, ItemData backGroundItem) {
        super(rows);
        this.backGroundItem = backGroundItem;
    }

    @Override
    public void registerItems() {
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < 9; b++) {
                items[a][b] = backGroundItem;
            }
        }
    }
}