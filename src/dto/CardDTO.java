package dto;

import cards.Card;

import java.util.ArrayList;

public class CardDTO {
    private int mana;
    private int health;
    private String description;
    private ArrayList<String> colors;
    private String name;

    public CardDTO(final Card card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    /**
     * Obtine mana cost al cartii
     *
     * @return mana cost
     */
    public int getMana() {
        return mana;
    }

    /**
     * Seteaza mana cost al cartii
     *
     * @param mana mana cost
     */
    public void setMana(final int mana) {
        this.mana = mana;
    }

    /**
     * Obtine sanatatea cartii
     *
     * @return sanatatea
     */
    public int getHealth() {
        return health;
    }

    /**
     * Seteaza sanatatea cartii
     *
     * @param health sanatatea
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Obtine descrierea cartii
     *
     * @return descrierea
     */
    public String getDescription() {
        return description;
    }

    /**
     * Seteaza descrierea cartii
     *
     * @param description descrierea
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Obtine lista de culori a cartii
     *
     * @return lista de culori
     */
    public ArrayList<String> getColors() {
        return colors;
    }

    /**
     * Seteaza lista de culori a cartii
     *
     * @param colors lista de culori
     */
    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    /**
     * Obtine numele cartii
     *
     * @return numele
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele cartii
     *
     * @param name numele
     */
    public void setName(final String name) {
        this.name = name;
    }
}
