package tictactoe.bll;

import java.awt.*;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
    private static final int MINUS_ET = -1;
    private static final int BOARD_SIZE = 3;

    private int winner = -1;
    private int nextPlayer = 0;
    private int[][] boardSize = new int[BOARD_SIZE][BOARD_SIZE];
    private char[][] boardSizeTwo = new char[3][3];

    public GameBoardTwoPlayer()
    {
        newGame();
    }


    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        return nextPlayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. If the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    @Override
    public boolean play(int col, int row)
    {
        if (isGameOver() || boardSize[col][row] != MINUS_ET)
        {
            return false;
        }

        boardSize[col][row] = nextPlayer;

        if (checkWinner())
        {
            winner = nextPlayer;
        }
        if(nextPlayer == 0)
        {
            nextPlayer = 1;
        } else {
            nextPlayer = 0;
        }
        return true;
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {
        if (checkWinner() || gameDraw())
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        return winner;
    }

    private boolean gameDraw()
    {
        for (int c = 0; c < boardSize.length;c++)
        {
            for (int r = 0; r < boardSize[c].length;r++)
            {
                if (boardSize[c][r] == MINUS_ET)
                {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        for (int c = 0; c < boardSize.length;c++)
        {
            for (int r = 0; r < boardSize[c].length;r++)
            {
                boardSize[c][r] = MINUS_ET;
            }
        }
        nextPlayer = 0;
        winner = -1;
    }

    /**
     * Boolean that checks if any player has 3 in a row in any direction.
     * [0,0  0,1  0,2]
     * [1,0  1,1  1,2]
     * [2,0  2,1  2,2]
     * @return true if 3 of the same symbols are next to each other. Otherwise false.
     */
    public boolean checkWinner()
    {
        // Loop der tjekker columns. Hvis der er 3 af de samme symboler ved siden af hinanden på X-axen,
        // returner den true.
        for (int c = 0; c < BOARD_SIZE;c++)
        {
           if ((boardSize[0][c] == boardSize[1][c]) && (boardSize[1][c] == boardSize[2][c]) && boardSize[2][c] != MINUS_ET)
           {
               return true;
           }
        }

        // Loop der tjekker rows. Hvis der er 3 af de samme symboler ved siden af hinanden på Y-axen,
        // returner den true.
        for (int r = 0; r < BOARD_SIZE;r++)
        {
            if (boardSize[r][0] == boardSize[r][1] && boardSize[r][1] == boardSize[r][2] && boardSize[r][0] != MINUS_ET)
            {
                return true;
            }
        }
        // If command der tjekker diagonalt om der er 3 på stribe.
        //

        if(boardSize[0][0] == boardSize[1][1] && boardSize[1][1] == boardSize[2][2] && boardSize[0][0] != MINUS_ET
                || boardSize[2][0] == boardSize[1][1] && boardSize[1][1] == boardSize[0][2] && boardSize[2][0] != MINUS_ET)
        {
            return true;
        }
        else {
            return false;
        }
    }
}