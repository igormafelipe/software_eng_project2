import java.util.*;

public class King extends Piece {

    private String BLACK_KING = "bk";
    private String WHITE_KING = "wk";

    public King(Color c) { this.setColor(c); }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.BLACK) { return BLACK_KING; }
        else if (this.color() == Color.WHITE) { return WHITE_KING; }
        else { throw new IllegalArgumentException(); }
    }

    public List<String> moves(Board b, String loc) {
	    List<String> validMoves = new ArrayList<String>();
        int col = boardHelper.getCol(loc);
        int row = boardHelper.getRow(loc);
        Color originalColor = this.color();
        int[][] tocheck = {{-1, 1}, {0, 1}, {1, 1}, 
                           {-1, 0},         {1, 0},
                           {-1,-1}, {0,-1}, {1,-1}};

        for (int[] possibleMovement : tocheck) {
            int currCol = col + possibleMovement[0];
            int currRow = row + possibleMovement[1];
            if (currCol >= 0 && currRow >= 0 && currCol <= 7 && currRow <= 7){
                String currLoc = boardHelper.coordinateToLoc(
                    col+possibleMovement[0],
                    row+possibleMovement[1]);
                if (b.getPiece(currLoc) == null) {
                    validMoves.add(currLoc);                                    
                } else if (b.getPiece(currLoc) != null && 
                           b.getPiece(currLoc).color() != originalColor) {
                    validMoves.add(currLoc);
                }
            }
        }
        return validMoves;
    }

}