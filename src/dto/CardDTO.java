package dto;

import cards.Minion;

import java.util.ArrayList;

public class CardDTO {
    private int mana;
    private int health;
    private String description;
    private ArrayList<String> colors;
    private String name;

    public CardDTO(Minion minion) {
        this.mana = minion.getMana();
        this.health = minion.getHealth();
        this.description = minion.getDescription();
        this.colors = minion.getColors();
        this.name = minion.getName();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(final int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
