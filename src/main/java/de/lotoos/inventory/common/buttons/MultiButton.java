package de.lotoos.inventory.common.buttons;

import java.util.Map;

/**
 * @author hyperspace_pilot
 * @param <T> Identifier-Type to get the correct button.
 */
public abstract class MultiButton<T> extends Button {

    protected Map<T, Button> buttons;

    public MultiButton(Map<T, Button> buttons) {
        this.buttons = buttons;
    }
}