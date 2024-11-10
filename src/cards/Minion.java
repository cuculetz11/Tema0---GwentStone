package cards;


public abstract class Minion extends Card {
    private int attackDamage;

    /**
     * Obtine atacul minionului
     * @return atacul minionului
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * Seteaza atacul minionului
     * @param attackDamage atacul cartii
     */
    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }

    /**
     * Ne arata daca cartea este de tipul 'Tank'
     * @return true daca cartea e tank; false altfel
     */
    public abstract boolean isTank();

    /**
     * Ne spune daca cartea este pe randul din fata al playerului
     * @return true daca e pe randul din fata; false altfel
     */
    public abstract boolean isFront();
}
