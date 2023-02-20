import java.util.*;

public class Hole {
    private ArrayList<Integer> red = new ArrayList<Integer>();
    private ArrayList<Integer> blue = new ArrayList<Integer>();
    private ArrayList<Integer> open = new ArrayList<Integer>();
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String RESET = "\u001B[0m";

    public Hole() {
        for (int r = 0; r < 4; r++) {
            red.add(r);
        }
        for (int o = 4; o < 6; o++) {
            open.add(o);
        }
        for (int b = 6; b < 10; b++) {
            blue.add(b);
        }
    }

    public String getPeg(int location) {
        for (int r : red) {
            if (r == location) {
                return RED + "R" + RESET;
            }
        }
        for (int b : blue) {
            if (b == location) {
                return BLUE + "B" + RESET;
            }
        }
        return " ";
    }

    public void changeRed(int oldLocation, int newLocation) {
        for (int o = 0; o < open.size(); o++) {
            if (open.get(o) == newLocation) {
                open.remove(o);
            }
        }
        for (int r = 0; r< red.size(); r++) {
            if (red.get(r) == oldLocation) {
                red.remove(r);
            }
        }
        red.add(newLocation);
    }

    public void changeBlue(int oldLocation, int newLocation) {
        for (int o = 0; o < open.size(); o++) {
            if (open.get(o) == newLocation) {
                open.remove(o);
            }
        }
        for (int b = 0; b < blue.size(); b++) {
            if (blue.get(b) == oldLocation) {
                blue.remove(b);
            }
        }
        blue.add(newLocation);
    }

    public boolean isLegal(int oldLocation, int newLocation) {
        if (getPeg(oldLocation).equals(RED + "R" + RESET)) {
            for (int o : open) {
                if (newLocation - 1 == o) {
                    System.out.print("Sorry, you can't do this; you aren't jumping over a peg. ");
                    return false;
                }
            }
            if (!(newLocation != oldLocation + 1 || newLocation != oldLocation + 2)) {
                System.out.print("Sorry, you aren't moving forward. ");
                return false;
            }
        } else {
            for (int o : open) {
                if (newLocation + 1 == o) {
                    System.out.print("Sorry, you can't do this; you aren't jumping over a peg. ");
                    return false;
                }
            }
            if (!(newLocation != oldLocation - 1 || newLocation != oldLocation - 2)) {
                System.out.print("Sorry, you aren't moving forward. ");
                return false;
            }
        }
        if (!getPeg(newLocation).equals(" ")) {
            System.out.print("That is illegal because it's not open. ");
            return false;
        }
        if (newLocation < 0 || newLocation > 9) {
            System.out.print("You can't do that, you'd be moving it off the board! ");
            return false;
        }
        return true;
    }

    public boolean winGame() {
        for (int b = 0; b < 4; b++) {
            if (!getPeg(b).equals(BLUE + "B" + RESET)) {
                return false;
            }
        }
        for (int r = 6; r < 10; r++) {
            if (!getPeg(r).equals(RED + "R" + RESET)) {
                return false;
            }
        }
        return true;
    }
}
