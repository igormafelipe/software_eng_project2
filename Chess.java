import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 2) {
			System.out.println("Usage: java Chess [layout] [moves]");
			throw new IllegalArgumentException();
		}
		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());

		Board theBoard = Board.theBoard();

		File layoutFile = new File(args[0]);
		File movesFile = new File(args[1]);

		// Will throw filenotfound exception if file does not exist
		Scanner layoutReader = new Scanner(layoutFile);
		Scanner movesReader = new Scanner(movesFile);
		
		//POPULATE BOARD
		while (layoutReader.hasNextLine()) {
			String line = layoutReader.nextLine();
			if (!line.contains("#")) { 
				if (!line.matches("^[a-h]{1}[1-8]{1}[=]{1}[bw]{1}[kqnbrp]{1}")) { 
					System.out.println("Layout file not in proper format.");
					throw new IllegalArgumentException();
				}
				String loc = line.substring(0, 2);
				String p = line.substring(3,5);
				theBoard.addPiece(Piece.createPiece(p), loc);
			};
		}

		//PLAY GAME
		while (movesReader.hasNextLine()) {
			String line = movesReader.nextLine();
			if (!line.contains("#")) {
				if(!line.matches("^[a-h]{1}[1-8]{1}[-]{1}[a-h]{1}[1-8]{1}")) {
					System.out.println("Moves file not in proper format.");
					throw new IllegalArgumentException();
				}
				String initialCoord = line.substring(0,2);
				String finalCoord = line.substring(3,5);
				theBoard.movePiece(initialCoord, finalCoord);
			}
		}

		layoutReader.close();
		movesReader.close();

		// Leave the following code at the end of the simulation:
		System.out.println("Final board:");
		Board.theBoard().iterate(new BoardPrinter());
	}
}