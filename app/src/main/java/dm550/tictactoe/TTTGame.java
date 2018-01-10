package dm550.tictactoe;

/** main class creating a board and the GUI
 * defines the game play
 */
public class TTTGame implements Game {
    //this is not a test
    /** currently active player */
    private int currentPlayer;

    /** total number of players */
    private int numPlayers;
    
    /** the board we play on */
    private TTTBoard board;
    
    /** the gui for board games */
    private UserInterface ui;
    
    /** constructor that gets the number of players */
    public TTTGame() {
        this.currentPlayer = 1;
        this.numPlayers = 2;
        this.board = new TTTBoard(2);
    }

    @Override
    public String getTitle() { return "Connect 4";
    }

    @Override
    public void addMove(Coordinate pos) {
        this.board.addMove(pos, this.currentPlayer);
        if (this.currentPlayer == this.numPlayers) {
            this.currentPlayer = 1;
        } else {
            this.currentPlayer++;
        }
    }

    @Override
    public String getContent(Coordinate pos) {
        String result = "";
        int player = this.board.getPlayer(pos);
        if (player > 0) {
            result += player;
        }
        return result;
    }

    @Override
    public int getHorizontalSize() {
        return this.board.getSize() + 1;
    }

    @Override
    public int getVerticalSize() {
        return this.board.getSize();
    }

    @Override
    public void checkResult() {
        int winner = this.board.checkWinning();
        if (this.board.checkFull()) {
            this.ui.showResult("This is a DRAW!");
        }
        if (winner > 0) {
            this.ui.showResult("Player "+winner+" wins!");
        }
    }

    @Override
    public boolean isFree(Coordinate pos) {
        return this.board.isFree(pos);
    }

    @Override
    public void setUserInterface(UserInterface ui) {
        this.ui = ui;
        
    }
    
    public String toString() {
        return "Board before Player "+this.currentPlayer+" of "+this.numPlayers+"'s turn:\n"+this.board.toString();
    }

}
