import java.util.*;

public class Rook extends Piece {

    private String BLACK_ROOK = "br";
    private String WHITE_ROOK = "wr";

    public Rook(Color c) { this.setColor(c); }

    public String toString() {
        if (this.color() == Color.BLACK) { return BLACK_ROOK; }
        else if (this.color() == Color.WHITE) { return WHITE_ROOK; }
        else { throw new IllegalArgumentException(); }
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<String>();
        if (b.getPiece(loc) == null) { return possibleMoves; }
        possibleMoves.addAll(boardHelper.checkLeftHorizontal(b, loc));
        possibleMoves.addAll(boardHelper.checkRightHorizontal(b, loc));
        possibleMoves.addAll(boardHelper.checkUpVertical(b, loc));
        possibleMoves.addAll(boardHelper.checkDownVertical(b, loc));
        return possibleMoves;
    }

}