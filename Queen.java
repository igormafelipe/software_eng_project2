import java.util.*;

public class Queen extends Piece {

    private String BLACK_QUEEN = "bq";
    private String WHITE_QUEEN = "wq";

    public Queen(Color c) { this.setColor(c); }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.BLACK) { return BLACK_QUEEN; }
        else if (this.color() == Color.WHITE) { return WHITE_QUEEN; }
        else { throw new IllegalArgumentException(); }
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<String>();
        possibleMoves.addAll(boardHelper.checkLeftHorizontal(b, loc));
        possibleMoves.addAll(boardHelper.checkRightHorizontal(b, loc));
        possibleMoves.addAll(boardHelper.checkUpVertical(b, loc));
        possibleMoves.addAll(boardHelper.checkDownVertical(b, loc));
        possibleMoves.addAll(boardHelper.checkLeftDownDiagonal(b, loc));
        possibleMoves.addAll(boardHelper.checkRightDownDiagonal(b, loc));
        possibleMoves.addAll(boardHelper.checkLeftUpDiagonal(b, loc));
        possibleMoves.addAll(boardHelper.checkRightUpDiagonal(b, loc));
        return possibleMoves;
    }
}