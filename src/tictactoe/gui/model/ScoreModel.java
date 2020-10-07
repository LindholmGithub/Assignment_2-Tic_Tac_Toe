package tictactoe.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ScoreModel {


    private ObservableList<String> winners;

    public ScoreModel() {
        winners = FXCollections.observableArrayList();

    }
    public ObservableList<String> getWinners() {
        return winners;
    }
    public void setNextWinner(String winner) {
        switch (winner) {
            case "1":
                winners.add(0,"Player 1");
                break;
            case "0" :
                winners.add(0,"Player 0");
                break;
            case "-1" :
                winners.add(0,"Draw");
                break;
            default :
                System.out.println("Unknown Statement");
        }
    }
}