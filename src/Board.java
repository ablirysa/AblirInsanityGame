import java.util.*;

public class Board {
    Scanner scan = new Scanner(System.in);
    private String[] board;
    private Hole hole = new Hole();
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public Board() {
        board = new String[10];
        for (int i = 0; i < board.length; i++) {
            board[i] = "{" + hole.getPeg(i) + "} ";
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = "{" + hole.getPeg(i) + "} ";
            System.out.print(board[i]);
        }
        System.out.println();
        for (int n = 1; n <= board.length; n++) {
            System.out.print("[" + n + "] ");
        }
        System.out.println();
    }

    public void playGame() {
        while (!hole.winGame()){
            printBoard();
            System.out.print("Where is the peg you want to move? ");
            int pegLocation = scan.nextInt() - 1;
            scan.nextLine(); // buffer
            while (pegLocation < 0 || pegLocation > 9 || hole.getPeg(pegLocation).equals(" ")) {
                if (pegLocation < 0 || pegLocation > 9) {
                    System.out.print("That's not on the board. Please pick a peg: ");
                    pegLocation = scan.nextInt() - 1;
                    scan.nextLine(); // buffer
                } else if (hole.getPeg(pegLocation).equals(" ")) {
                    System.out.print("There is no peg there! Please pick another one: ");
                    pegLocation = scan.nextInt() - 1;
                    scan.nextLine(); // buffer
                }
            }
            System.out.print("Where do you want to move the peg? ");
            int newPegLocation = scan.nextInt() - 1;
            scan.nextLine(); // buffer
            while (!hole.isLegal(pegLocation, newPegLocation)) {
                System.out.print("Pick another location: ");
                newPegLocation = scan.nextInt() - 1;
                scan.nextLine(); // buffer
            }
            if (hole.getPeg(pegLocation).equals(RED + "R" + RESET)) {
                hole.changeRed(pegLocation, newPegLocation);
            } else {
                hole.changeBlue(pegLocation, newPegLocation);
            }

         }
         System.out.println("Great job! You have won the Insanity Game!");
    }
}