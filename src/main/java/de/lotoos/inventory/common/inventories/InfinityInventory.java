package de.lotoos.inventory.common.inventories;


import de.lotoos.inventory.common.Inventory;
import de.lotoos.inventory.common.buttons.Button;
import de.lotoos.inventory.common.items.ItemData;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;

import java.util.List;

/**
 * @author hyperspace_pilot
 * @param <T> Type of Objects in InfinityInventory
 */
public abstract class InfinityInventory<T> extends Inventory {

    protected List<T> list;
    protected int currentPage;
    protected double maxPage;

    public InfinityInventory(Player player, String title, int rows) {
        super(player, title, rows);
    }

    public void registerNextPageButton(int row, int slot, ItemData itemData) {
        registerButtonAndItem(row, slot, new Button() {
            @Override
            public void onClick(InventoryAction inventoryAction) {
                currentPage++;
                inventoryBuilder.executeUpdate();
            }
        }, itemData);
    }

    public void registerLastPageButton(int row, int slot, ItemData itemData) {
        registerButtonAndItem(row, slot, new Button() {
            @Override
            public void onClick(InventoryAction inventoryAction) {
                currentPage--;
                inventoryBuilder.executeUpdate();
            }
        }, itemData);
    }

    public double getMaxPage() {
        return maxPage;
    }

    public List<T> getList() {
        return list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setMaxPage(double maxPage) {
        this.maxPage = maxPage;
    }
}