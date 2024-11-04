package dto;

import cards.Minion;

import java.util.ArrayList;

public class MinionDTO {
    private int mana;
    private int health;
    private int attackDamage;
    private String description;
    private ArrayList<String> colors;
    private String name;

    public MinionDTO(final Minion minion) {
        this.mana = minion.getMana();
        this.health = minion.getHealth();
        this.description = minion.getDescription();
        this.colors = minion.getColors();
        this.name = minion.getName();
        this.attackDamage = minion.getAttackDamage();
    }
    /**
     * Obtine damage-ul de atac al minionului
     *
     * @return damage-ul de atac
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * Seteaza damage-ul de atac al minionului
     *
     * @param attackDamage damage-ul de atac
     */
    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }

    /**
     * Obtine mana cost al minionului
     *
     * @return mana cost
     */
    public int getMana() {
        return mana;
    }

    /**
     * Seteaza mana cost al minionului
     *
     * @param mana mana cost
     */
    public void setMana(final int mana) {
        this.mana = mana;
    }

    /**
     * Obtine sanatatea minionului
     *
     * @return sanatatea
     */
    public int getHealth() {
        return health;
    }

    /**
     * Seteaza sanatatea minionului
     *
     * @param health sanatatea
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Obtine descrierea minionului
     *
     * @return descrierea
     */
    public String getDescription() {
        return description;
    }

    /**
     * Seteaza descrierea minionului
     *
     * @param description descrierea
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Obtine lista de culori a minionului
     *
     * @return lista de culori
     */
    public ArrayList<String> getColors() {
        return colors;
    }

    /**
     * Seteaza lista de culori a minionului
     *
     * @param colors lista de culori
     */
    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    /**
     * Obtine numele minionului
     *
     * @return numele
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele minionului
     *
     * @param name numele
     */
    public void setName(final String name) {
        this.name = name;
    }
}
