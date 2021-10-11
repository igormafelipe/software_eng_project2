import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] pieces = new Piece[8][8];

    private static Board single_board = null;
    private List<BoardListener> listeners= new ArrayList<BoardListener>();

    private Board() { }
    
    public static Board theBoard() {
        if (single_board == null) { 
            single_board = new Board(); 
        }
        return single_board;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
	    if(!loc.matches("^[a-h]{1}[1-8]{1}")) { 
            throw new IllegalArgumentException();
        }

        int col = boardHelper.getCol(loc);
        int row = boardHelper.getRow(loc);

        return pieces[col][row];
    }

    public void addPiece(Piece p, String loc) {
        // getPiece already takes care of checking if loc is valid.
        if(this.getPiece(loc) != null) { 
            throw new IllegalArgumentException();
        }
        int col = boardHelper.getCol(loc);
        int row = boardHelper.getRow(loc);
        pieces[col][row] = p;
    }

    public void movePiece(String from, String to) {
        Piece moving = this.getPiece(from);
        if (moving == null) {
            throw new IllegalArgumentException();
        }

        if (!moving.moves(this, from).contains(to)) {
            throw new IllegalArgumentException();
        }

        int fcol = boardHelper.getCol(from);
        int frow = boardHelper.getRow(from);

        int tcol = boardHelper.getCol(to);
        int trow = boardHelper.getRow(to);

        this.pieces[tcol][trow] = pieces[fcol][frow];
        this.pieces[fcol][frow] = null;

        if (this.getPiece(to) != null) {
            for (BoardListener listener : listeners) {
                listener.onCapture(this.getPiece(from), this.getPiece(to));
            }
        }

        for (BoardListener listener : listeners) {
            listener.onMove(from, to, this.getPiece(from));
        }

    }

    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
        listeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
        listeners.remove(bl);
    }

    public void removeAllListeners() {
	    listeners.clear();
    }

    public void iterate(BoardExternalIterator bi) {
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                String loc = boardHelper.coordinateToLoc(i, j);
                bi.visit(loc, getPiece(loc));
            }
        }
    }
}