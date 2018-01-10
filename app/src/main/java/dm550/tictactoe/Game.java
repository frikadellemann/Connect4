package dm550.tictactoe;

public interface Game {

    /** title of the game */
    String getTitle();
    
    /** horizontal size of the board */
    int getHorizontalSize();

    /** vertical size of the board */
    int getVerticalSize();

    /** string representation of the position
     * useful for user interface
     */
    String getContent(Coordinate pos);

    /**
     *void CFGame(); */


    /** record a move on a given position */
    void addMove(int x);

    /** check if some player wins or it is a draw */
    void checkResult();

    /** returns true, if and only if, the position is free */
    boolean isFree(Coordinate pos);

    /** returns true, if and only if, the column has space */
    boolean isFreeCol(int x);
    
    /** provide a user interface to the game */
    void setUserInterface(UserInterface ui);
    
}
