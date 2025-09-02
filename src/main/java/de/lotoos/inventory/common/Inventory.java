package de.lotoos.inventory.common;

import de.lotoos.inventory.common.items.ItemData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class Inventory {

    protected Player player;
    protected String title;
    protected String rawTitle;
    protected int rows;
    protected InventoryDesign design;
    protected Map<Integer, InventoryButton> buttons;
    protected boolean animated = false;
    protected InventoryAnimation animation;
    protected boolean closeable = true;
    protected boolean created = false;
    protected InventoryBuilder inventoryBuilder;

    public Inventory(Player player, String title, int rows) {
        this.player = player;
        this.title = title;
        this.rows = rows;
        this.buttons = new HashMap<>();
        this.animation = new InventoryAnimation();
    }

    public Inventory(Player player, String title, int rows, boolean animated) {
        this.player = player;
        this.title = title;
        this.rows = rows;
        this.buttons = new HashMap<>();
        this.animated = animated;
        this.animation = new InventoryAnimation();
    }

    public void registerButtonAndItem(int row, int slot, InventoryButton inventoryButton, ItemData itemData) {
        registerButtonAndItem(row, slot, inventoryButton, itemData, 0L);
    }

    public void registerButtonAndItem(int row, int slot, InventoryButton inventoryButton, ItemData itemData, long timeToWait) {
        registerButtonAndItem(row * 9 + slot, inventoryButton, itemData, timeToWait);
    }

    public void registerButtonAndItem(int slot, InventoryButton inventoryButton, ItemData itemData) {
        registerButtonAndItem(slot, inventoryButton, itemData, 0L);
    }

    public void registerButtonAndItem(int slot, InventoryButton inventoryButton, ItemData itemData, long timeToWait) {
        registerButton(slot, inventoryButton);
        registerItem(slot, itemData, timeToWait);
    }

    public void registerButton(int row, int slot, InventoryButton inventoryButton) {
        registerButton(row * 9 + slot, inventoryButton);
    }

    public void registerButton(int slot, InventoryButton inventoryButton) {
        inventoryButton.onAdd();
        this.buttons.put(slot, inventoryButton);
    }

    public void registerItem(int row, int slot, ItemData itemData) {
        registerItem(row * 9 + slot, itemData);
    }

    public void registerItem(int slot, ItemData itemData) {
        registerItem(slot, itemData, 0L);
    }

    public void registerItem(int row, int slot, ItemData itemData, long timeToWait) {
        registerItem(row * 9 + slot, itemData, timeToWait);
    }

    public void registerItem(int slot, ItemData itemData, long timeToWait) {
        this.animation.registerSlot(slot, itemData, timeToWait);
    }

    public void clearSlot(int row, int slot, ItemData itemData) {
        clearSlot(row * 9 + slot, itemData);
    }

    public void clearSlot(int slot, ItemData itemData) {
        this.buttons.remove(slot);
        if (this.inventoryBuilder.bukkitInventory != null) {
            if (itemData != null) {
                this.inventoryBuilder.bukkitInventory.setItem(slot, itemData.build());
            } else {
                this.inventoryBuilder.bukkitInventory.setItem(slot, null);
            }
        }
    }

    public abstract Inventory fillInventory();

    public abstract Inventory clearInventory();

    public abstract void onOpen();

    public abstract void onClose();

    public void setRawTitle(String rawTitle) {
        this.rawTitle = rawTitle;
    }

    public void setDesign(InventoryDesign design) {
        this.design = design;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public void setCloseable(boolean closeable) {
        this.closeable = closeable;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public void setInventoryBuilder(InventoryBuilder inventoryBuilder) {
        this.inventoryBuilder = inventoryBuilder;
    }

    public int getRows() {
        return rows;
    }

    public InventoryAnimation getAnimation() {
        return animation;
    }

    public InventoryBuilder getInventoryBuilder() {
        return inventoryBuilder;
    }

    public InventoryDesign getDesign() {
        return design;
    }

    public Map<Integer, InventoryButton> getButtons() {
        return buttons;
    }

    public Player getPlayer() {
        return player;
    }

    public String getRawTitle() {
        return rawTitle;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAnimated() {
        return animated;
    }

    public boolean isCloseable() {
        return closeable;
    }

    public boolean isCreated() {
        return created;
    }
}
