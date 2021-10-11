import java.util.*;

public class Bishop extends Piece {

    private String BLACK_BISHOP = "bb";
    private String WHITE_BISHOP = "wb";

    public Bishop(Color c) { this.setColor(c); }

    public String toString() {
        if (this.color() == Color.BLACK) { return BLACK_BISHOP; }
        else if (this.color() == Color.WHITE) { return WHITE_BISHOP; }
        else { throw new IllegalArgumentException(); }
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<String>();
        possibleMoves.addAll(boardHelper.checkLeftDownDiagonal(b, loc));
        possibleMoves.addAll(boardHelper.checkRightDownDiagonal(b, loc));
        possibleMoves.addAll(boardHelper.checkLeftUpDiagonal(b, loc));
        possibleMoves.addAll(boardHelper.checkRightUpDiagonal(b, loc));
        return possibleMoves;
    }

}