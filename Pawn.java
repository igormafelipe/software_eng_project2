import java.util.*;

public class Pawn extends Piece {

    private String BLACK_PAWN = "bp";
    private String WHITE_PAWN = "wp";

    public Pawn(Color c) { 
        this.setColor(c);
    }
    // implement appropriate methods

    public String toString() {
	    if (this.color() == Color.BLACK) { return BLACK_PAWN; }
        else if (this.color() == Color.WHITE) { return WHITE_PAWN; }
        else { throw new IllegalArgumentException(); }
    }

    // && - Will stop if first if conditional is false
    public List<String> moves(Board b, String loc) {
        List<String> validMoves = new ArrayList<String>();

        String leftCol = String.valueOf((char) (loc.charAt(0)-1));
        String rightCol = String.valueOf((char) (loc.charAt(0)+1));
        String aboveRow = String.valueOf((char) (loc.charAt(1)+1));
        String bellowRow = String.valueOf((char) (loc.charAt(1)-1));
        String aboveRow2 = String.valueOf((char) (loc.charAt(1)+2));
        String bellowRow2 = String.valueOf((char) (loc.charAt(1)-2));

        if (this.color() == Color.WHITE) {
            if( loc.charAt(1) == '8') { 
                return validMoves; 
            } else {
                //Checking diagonals
                if (loc.charAt(0) != 'a' && 
                    b.getPiece(leftCol+aboveRow) != null &&
                    b.getPiece(leftCol+aboveRow).color() != Color.WHITE) {
                    validMoves.add(leftCol+aboveRow);
                }
                if (loc.charAt(0) != 'h' && 
                    b.getPiece(rightCol+aboveRow) != null &&
                    b.getPiece(rightCol+aboveRow).color() != Color.WHITE) {
                    validMoves.add(rightCol+aboveRow);
                }

                //Checking above, cannot eat so only check if null
                if (b.getPiece(loc.charAt(0)+aboveRow) == null) {
                    validMoves.add(loc.charAt(0)+aboveRow);
                }

                if (loc.charAt(1) == '2' && 
                    b.getPiece(loc.charAt(0)+aboveRow2) == null) {
                    validMoves.add(loc.charAt(0)+aboveRow2);
                }
            }
        } else if (this.color() == Color.BLACK) {
            if( loc.charAt(1) == '1') { 
                return validMoves; 
            } else {
                //Checking diagonals
                if (loc.charAt(0) != 'a' && 
                    b.getPiece(leftCol+bellowRow) != null &&
                    b.getPiece(leftCol+bellowRow).color() != Color.BLACK) {
                    validMoves.add(leftCol+bellowRow);
                }
                if (loc.charAt(0) != 'h' && 
                    b.getPiece(rightCol+bellowRow) != null &&
                    b.getPiece(rightCol+bellowRow).color() != Color.BLACK) {
                    validMoves.add(rightCol+bellowRow);
                }

                //Checking above, cannot eat so only check if null
                if (b.getPiece(loc.charAt(0)+bellowRow) == null) {
                    validMoves.add(loc.charAt(0)+bellowRow);
                }

                if (loc.charAt(1) == '7' && 
                    b.getPiece(loc.charAt(0)+bellowRow2) == null) {
                    validMoves.add(loc.charAt(0)+bellowRow2);
                }
            }
        }
        return validMoves;
    }
}