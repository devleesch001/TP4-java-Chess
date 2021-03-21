package test.appli;

import test.Color;
import test.Coord;
import test.chessPiece.*;
import test.game.ChessBoard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class tp2ex1 {
    public static void main(String[] args) {
        System.out.println("for start new parti write : start");
        System.out.println("for load an saved parti write : load");
        System.out.println("in game for save parti write : save");


        Scanner starter = new Scanner(System.in);
        String command = starter.nextLine();

        if (command.equals("start")) {
            chess(System.in);
        } else if (command.equals("load")) {
            try {
                File file = new File("parti.txt");
                InputStream stream = new FileInputStream(file);
                chess(stream);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        starter.close();
    }

    private static void chess(InputStream stream) {
        try {
            Scanner scanner = new Scanner(stream);
            System.out.println("Game started !");

            ChessBoard board = new ChessBoard();


            Rook white_rook_1 = new Rook(board, new Coord(0,0), Color.WHITE);
            Knight white_knight_1 = new Knight(board, new Coord(1,0), Color.WHITE);
            Bishop white_bishop_1 = new Bishop(board, new Coord(2,0), Color.WHITE);
            Queen white_queen = new Queen(board, new Coord(3,0), Color.WHITE);
            King white_king = new King(board, new Coord(4, 0), Color.WHITE);
            Bishop white_bishop_2 = new Bishop(board, new Coord(5,0), Color.WHITE);
            Knight white_knight_2 = new Knight(board, new Coord(6,0), Color.WHITE);
            Rook white_rook_2 = new Rook(board, new Coord(7,0), Color.WHITE);

            Pawn[] white_pawns = new Pawn[8];
            for (int i = 0; i < 8; i++) {
                white_pawns[i] = new Pawn(board, new Coord(i, 1), Color.WHITE);
            }

            Rook black_rook_1 = new Rook(board, new Coord(0, 7), Color.BLACK);
            Knight black_knight_1 = new Knight(board, new Coord(1, 7), Color.BLACK);
            Bishop black_bishop_1 = new Bishop(board, new Coord(2, 7), Color.BLACK);
            King black_king = new King(board, new Coord(3, 7), Color.BLACK);
            Queen black_queen = new Queen(board, new Coord(4,7), Color.BLACK);
            Bishop black_bishop_2 = new Bishop(board, new Coord(5,7), Color.BLACK);
            Knight black_knight_2 = new Knight(board, new Coord(6,7), Color.BLACK);
            Rook black_rook_2 = new Rook(board, new Coord(7,7), Color.BLACK);

            Pawn[] black_pawns = new Pawn[8];
            for (int i = 0; i < 8; i ++) {
                black_pawns[i] = new Pawn(board, new Coord(i, 6), Color.BLACK);
            }

            board.smartPrint();

            ArrayList<String> parti = new ArrayList<String>();

            while(true) {
                if (!scanner.hasNextLine()) {
                    scanner = new Scanner(System.in);
                }

                String move = scanner.nextLine();
                System.out.println(move);

                if (move.equals("q")) {
                    break;
                } else if (move.equals("save")) {
                    FileWriter writer = new FileWriter("parti.txt");

                    for(String str: parti) {
                        writer.write(str + System.lineSeparator());
                    }
                    writer.close();
                } else if (move.length() == 2) {
                    System.out.println("2 : " + move);

                    int[] i_move = new int[2];

                    for (int i = 0; i < 2; i++) {
                        i_move[i] = Character.digit(move.charAt(i), 10) - 1;
                    }

                    System.out.println(board.getCase(new Coord(i_move[0], i_move[1])).getPiece().legalMove());
                } else {

                    int[] i_move = new int[4];

                    for (int i = 0; i < 4; i++) {
                        i_move[i] = Character.digit(move.charAt(i), 10) - 1;
                    }

                    board.getCase(new Coord(i_move[0], i_move[1])).getPiece().move(new Coord(i_move[2], i_move[3]));
                    parti.add(move);

                    board.smartPrint();
                }
            }
            System.out.println(parti);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Game finish !");
        }

    }
}
