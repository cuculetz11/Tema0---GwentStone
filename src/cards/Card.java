package cards;

import error.ErrorManger;
import fileio.ActionsInput;
import game.Game;

import java.util.ArrayList;


public abstract class Card {
    private int mana;
    private String description;
    private ArrayList<String> colors;
    private String name;
    private int health;
    private boolean wasUsed;
    private boolean isFrozen;

    /**
     * Aceasta metoda ne spune daca cartea este inghetata sau nu
     * @return true daca e inghetata; false altfel
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     *
     * @param frozen seteaza true sau false acest atribut
     */
    public void setFrozen(final boolean frozen) {
        isFrozen = frozen;
    }

    /**
     * Aceasta metoda ne spune daca cartea si-a folosit atacul/abilitatea
     * @return true daca a folosit atacul/abilitatea; false altfel
     */
    public boolean isWasUsed() {
        return wasUsed;
    }

    /**
     * Seteaza daca cartea a fost folosita sau nu
     * @param wasUsed
     */
    public void setWasUsed(final boolean wasUsed) {
        this.wasUsed = wasUsed;
    }

    /**
     * Obține mana necesara pentru utilizarea cartii
     *
     * @return mana necesara
     */
    public int getMana() {
        return mana;
    }

    /**
     * Seteaza mana necesara pentru utilizarea cartii
     *
     * @param mana mana necesara
     */
    public void setMana(final int mana) {
        this.mana = mana;
    }

    /**
     * Obține sanatatea cartii
     *
     * @return sanatatea cartii
     */
    public int getHealth() {
        return health;
    }

    /**
     * Seteaza sanatatea cartii
     *
     * @param health sanatatea cartii
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Obține numele cartii
     *
     * @return numele cartii
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele cartii
     *
     * @param name numele cartii
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Obține culorile cartii
     *
     * @return lista de culori asociate cu cartea
     */
    public ArrayList<String> getColors() {
        return colors;
    }

    /**
     * Seteaza culorile cartii
     *
     * @param colors lista de culori pentru carte
     */
    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    /**
     * Obține descrierea cartii
     *
     * @return descrierea cartii
     */
    public String getDescription() {
        return description;
    }

    /**
     * Seteaza descrierea cartii
     *
     * @param description descrierea cartii
     */
    public void setDescription(final String description) {
        this.description = description;
    }
    /**
     * Aceasta metoda este suprascrisa de fiecare carte in parte
     * acest polimorfism ma ajuta sa nu rescriu pentru ficare carte un cod asemanator
     *
     * @param game reprezinta jocul in sine deoarce am nevoie de anumite atribute din acel obiect
     * @param action in special pentru input si pentru datele de afisare
     * @param error aici ma ocup de erorile ce pot aparea si le pun in out
     */
    public abstract void useAbility(Game game, ActionsInput action, ErrorManger error);

}
