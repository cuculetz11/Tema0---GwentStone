package debug;

import cards.Card;
import cards.Hero;
import dto.CardDTO;


import java.util.ArrayList;

public class DebugPlayerHero {
    private String command;
    private int playerIdx;
    private CardDTO output;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public CardDTO getOutput() {
        return output;
    }

    public void setOutput(CardDTO output) {
        this.output = output;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public DebugPlayerHero(String command, int playerIdx, Card output) {
        this.command = command;
        this.playerIdx = playerIdx;
        this.output = new CardDTO(output);
    }
}
