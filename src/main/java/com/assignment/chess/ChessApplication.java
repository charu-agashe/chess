package com.assignment.chess;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ChessApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean continueProgram = true;
		Scanner scanner = new Scanner(System.in);

		System.out.println("FindValidMoves");
		while (continueProgram) {
			ChessBoard board = new ChessBoard();
			Boolean validInput = false;
			Integer number = 0;
			String colour = "";
			String type = "";
			String position = "";
			ArrayList<Piece> piecesList = new ArrayList<>();

			number = getNumberOfPieces(scanner, number);

			for (int x = 1; x <= number; x++) {
				System.out.println("Piece " + x);
				colour = getPieceColor(scanner, colour);
				type = getTypeOfPiece(scanner, type);
				position = getPosition(scanner, board, position);
				createPiecesAndAddToBoard(board, colour, type, position, piecesList);
			}

			printValidMoves(piecesList);

			System.out.println("Continue (Y/N)? :");
			String continueStr = scanner.next();
			continueStr = continueStr.toUpperCase();
			if (continueStr.equals("Y")) {
				continueProgram = true;
			} else {
				continueProgram = false;
			}
		}
	}

	private void printValidMoves(ArrayList<Piece> piecesList) {
		for (Piece piece : piecesList) {
			ArrayList<String> possibleMoveCoordinate = piece.getPossibleMoves();
			Collections.sort(possibleMoveCoordinate);
			System.out.println(piece.getName() + " on " + piece.getPosStr() + " : " + Arrays.toString(possibleMoveCoordinate.toArray()));
		}
	}

	private void createPiecesAndAddToBoard(ChessBoard board, String colour, String type, String position, ArrayList<Piece> piecesList) {
		int xCoord;
		int yCoord;
		xCoord = board.getCoordMap().getX(position.substring(0,1));
		yCoord = board.getCoordMap().getY(position.substring(1));

		Piece piece = null;
		if (type.equals("R")) {
			piece = new Rook(type, colour, board, position);
		} else {
			piece = new Knight(type, colour, board, position);
		}
		piece.setCoordinates(xCoord, yCoord);
		piecesList.add(piece);
	}

	private String getPosition(Scanner scanner, ChessBoard board,  String position) {
		Boolean validInput = false;
		while (!validInput) {
			System.out.println("Enter position:");
			position = scanner.next();

			String xVal = position.substring(0, 1);
			String yVal = position.substring(1);
			if(board.areValidCoordinates(xVal,yVal)){

				validInput = true;
			} else {
				System.out.println("Enter valid position");
			}

		}
		return position;
	}

	private String getTypeOfPiece(Scanner scanner, String type) {
		Boolean validInput = false;
		while (!validInput) {
			System.out.println("Enter type (R/N) :");
			type = scanner.next();
			type = type.toUpperCase();
			if (type.equals("R") || type.equals("N")) {
				validInput = true;
			} else {
				System.out.println("Enter valid type.");
			}
		}
		return type;
	}

	private String getPieceColor(Scanner scanner, String colour) {
		Boolean validInput = false;
		while (!validInput) {
			System.out.println("Enter colour (W/B) :");
			colour = scanner.next();
			colour = colour.toUpperCase();
			if (colour.equals("W") || colour.equals("B")) {
				validInput = true;
			} else {
				System.out.println("Enter valid color.");
			}
		}
		return colour;
	}

	private Integer getNumberOfPieces(Scanner scanner, Integer number) {
		Boolean validInput = false;
		while (!validInput) {
			System.out.println("Enter number of pieces:");
			String num = scanner.nextLine();
			if(num != null && !num.isEmpty()) {
				number = Integer.valueOf(num);
				if (number > 0 && number <= 8) {
					validInput = true;
				} else {
					System.out.println("Enter number less than or equal to 8");
				}
			}
		}
		return number;
	}
}
