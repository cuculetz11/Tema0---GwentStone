package cards;


public abstract class Minion extends Card {
    private int attackDamage;

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public abstract boolean isTank();
    public abstract boolean isFront();
}
