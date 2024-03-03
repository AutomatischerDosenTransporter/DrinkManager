package net.nussi.aiit.drinkmanager.model;

import java.io.Serializable;

public enum DrinkTypeModel implements Serializable {
    HALF_LITTER("1/2 L"),
    THIRD_LITTER("1/3 L"),
    FOURTH_LITTER("1/4 L");

    public final String displayText;

    DrinkTypeModel(String displayText) {
        this.displayText = displayText;
    }
}
