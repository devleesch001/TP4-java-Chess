package test.appli;

import test.Color;
import test.Coord;
import test.chessPiece.*;
import test.game.ChessBoard;

import java.util.Scanner;

public class tp3ex1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Game started !");

            ChessBoard board = new ChessBoard();


            Rook white_rook_1 = new Rook(board, new Coord(0, 0), Color.WHITE);
            Knight white_knight_1 = new Knight(board, new Coord(1, 0), Color.WHITE);
            Bishop white_bishop_1 = new Bishop(board, new Coord(2, 0), Color.WHITE);
            Queen white_queen = new Queen(board, new Coord(3, 0), Color.WHITE);
            King white_king = new King(board, new Coord(4, 0), Color.WHITE);
            Bishop white_bishop_2 = new Bishop(board, new Coord(5, 0), Color.WHITE);
            Knight white_knight_2 = new Knight(board, new Coord(6, 0), Color.WHITE);
            Rook white_rook_2 = new Rook(board, new Coord(7, 0), Color.WHITE);

            Pawn[] white_pawns = new Pawn[8];
            for (int i = 0; i < 8; i++) {
                white_pawns[i] = new Pawn(board, new Coord(i, 1), Color.WHITE);
            }

            Rook black_rook_1 = new Rook(board, new Coord(0, 7), Color.BLACK);
            Knight black_knight_1 = new Knight(board, new Coord(1, 7), Color.BLACK);
            Bishop black_bishop_1 = new Bishop(board, new Coord(2, 7), Color.BLACK);
            King black_king = new King(board, new Coord(3, 7), Color.BLACK);
            Queen black_queen = new Queen(board, new Coord(4, 7), Color.BLACK);
            Bishop black_bishop_2 = new Bishop(board, new Coord(5, 7), Color.BLACK);
            Knight black_knight_2 = new Knight(board, new Coord(6, 7), Color.BLACK);
            Rook black_rook_2 = new Rook(board, new Coord(7, 7), Color.BLACK);

            Pawn[] black_pawns = new Pawn[8];
            for (int i = 0; i < 8; i++) {
                black_pawns[i] = new Pawn(board, new Coord(i, 6), Color.BLACK);
            }


            board.smartPrint();

//            board.getCase(0, 0).getPiece().move(new Coord(0, 5));
//            board.smartPrint();

            while (true) {
                String move = scanner.nextLine();
                System.out.println(move);

                if (move.equals("q")) {
                    break;
                }

                int[] i_move = new int[4];

                for (int i = 0; i < 4; i++) {
                    i_move[i] = Character.digit(move.charAt(i), 10) - 1;
                }


                board.getCase(new Coord(i_move[0], i_move[1])).getPiece().move(new Coord(i_move[2], i_move[3]));

                board.smartPrint();

            }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Game finish !");
        }

    }
}
