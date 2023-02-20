import java.util.*;

public class InsanityRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board game = new Board();

        System.out.println("Welcome to Insanity!");
        System.out.println("Do you want to learn how to play?" +
                "\n[1] Yes     [2] No");
        int instructionsChoice = scan.nextInt();
        scan.nextLine(); // buffer
        while (instructionsChoice < 1 || instructionsChoice > 2) {
            System.out.println("Sorry, that wasn't an option. Do you want to learn how to play?" +
                    "\n[1] Yes     [2] No");
            instructionsChoice = scan.nextInt();
            scan.nextLine(); // buffer
        } // if choice wasn't there
        if (instructionsChoice == 1) {
            System.out.println("- - - - - HOW TO PLAY - - - - -" +
                    "\nInsanity is a single-player game that includes eight colored pegs, the board will look like this:");
            game.printBoard();
            System.out.println("\nYou want to get the red pegs to the right side, and the blue pegs to the left." +
                    "\nIn order to play correctly, you can only move a peg to the next hole or over another peg.");
        } // if they chose to learn how to play
        System.out.println();
        System.out.println("Let's begin!");
        System.out.println("- - - - - STARTING GAME - - - - -");
        game.playGame();
    }
}
