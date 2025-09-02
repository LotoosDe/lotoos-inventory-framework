package de.lotoos.inventory.common;

import de.lotoos.inventory.common.items.ItemData;
import de.lotoos.inventory.common.util.Triple;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hyperspace_pilot
 */
public class InventoryAnimation {

    protected List<Triple<Integer, ItemData, Long>> animationData = new CopyOnWriteArrayList<>();
    protected boolean animating;

    public InventoryAnimation() {}

    public void registerSlot(int slot, ItemData itemData, Long timeToWait) {
        for (Triple<Integer, ItemData, Long> tuple : animationData) {
            if (tuple.getFirst() == slot) {
                animationData.remove(tuple);
            }
        }
        animationData.add(new Triple<>(slot, itemData, timeToWait));
    }

    public void clear() {
        this.animationData.clear();
    }

    public List<Triple<Integer, ItemData, Long>> getAnimationData() {
        return animationData;
    }

    public boolean isAnimating() {
        return animating;
    }

    public void setAnimating(boolean animating) {
        this.animating = animating;
    }
}