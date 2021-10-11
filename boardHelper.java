import java.util.*;

public class boardHelper {
    public static int getCol(String loc) {
        return loc.charAt(0)-97;
    }

    public static int getRow(String loc) {
        return loc.charAt(1)-49;
    }

    public static String coordinateToLoc(int col, int row) {
        String loc = new String();
        loc = Character.toString((char)(col+97)) + 
                Character.toString((char)(row+49));
        // System.out.println(col + " " + row + " " + "    " + loc);
        return loc;
    }

    //Assume piece exists in loc.
    public static List<String> checkRightUpDiagonal(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(col < 7 && row < 7) {
            col += 1;
            row += 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }

    //Assume piece exists in loc.
    public static List<String> checkLeftUpDiagonal(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(col > 0 && row < 7) {
            col -= 1;
            row += 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }

    //Assume piece exists in loc.
    public static List<String> checkRightDownDiagonal(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(col < 7 && row > 0) {
            col += 1;
            row -= 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }

    //Assume piece exists in loc.
    public static List<String> checkLeftDownDiagonal(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(col > 0 && row > 0) {
            col -= 1;
            row -= 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }


    public static List<String> checkLeftHorizontal(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(col > 0) {
            col -= 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }


    public static List<String> checkRightHorizontal(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(col < 7) {
            col += 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }

    public static List<String> checkUpVertical(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(row < 7) {
            row += 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }


    public static List<String> checkDownVertical(Board b, String loc, Color c) {
        List<String> possibleMoves = new ArrayList<String>();
        int col = getCol(loc);
        int row = getRow(loc);
        Color originalColor = c;
        while(row > 0) {
            row -= 1;
            // System.out.println("hello");
            if (b.getPiece(coordinateToLoc(col, row)) != null) {
                if (b.getPiece(coordinateToLoc(col, row)).color() != originalColor) {
                    possibleMoves.add(coordinateToLoc(col, row));
                }
                break;
            }
            possibleMoves.add(coordinateToLoc(col, row));
        }
        return possibleMoves;
    }
}