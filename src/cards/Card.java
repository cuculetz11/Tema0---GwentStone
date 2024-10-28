package cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public abstract class Card {
    private int mana;
    private String description;
    private ArrayList<String> colors;
    private String name;
    private int health;

    public abstract void useAbility();


}
