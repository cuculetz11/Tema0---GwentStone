package cards;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Minion extends Card {
    private int attackDamage;

    public abstract boolean isTank();
}
