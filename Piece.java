import java.util.*;

abstract public class Piece {

    private static HashMap<Character, PieceFactory> nameToFactory 
                                    = new HashMap<Character, PieceFactory>();
    private Color color;

    // Adds the given pf to a map, where the symbol is the key and the map itself is the value.
    public static void registerPiece(PieceFactory pf) {
        assert(pf != null);
        nameToFactory.put(pf.symbol(), pf); 
    }

    // Look up the factory in the map, and call it on the map.
    public static Piece createPiece(String name) {
        char type = name.charAt(1);
        Color color = name.charAt(0) == 'w' ? Color.WHITE : Color.BLACK;
	    return nameToFactory.get(type).create(color);
    }

    public Color color() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    abstract public String toString();
 
    abstract public List<String> moves(Board b, String loc);
}