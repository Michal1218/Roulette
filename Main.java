import java.util.Random;
import java.util.Scanner;

public class Main {


    public static Scanner sc = new Scanner(System.in);
    public static int[] red = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
    public static int[] black = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
    public static int[] green = {0};
    public static int balance = 1000;
    public static int bidAmmount;
    public static int bid;
    public static int hit;

    public static int randomNumber() {
        return new Random().nextInt(37);
    }

    public static void main(String[] args) {
        Bidding();
        roulette();
    }


    public static void roulette() {
        do {
            System.out.println("- Your balance: " + balance);
            System.out.print("Your bid: ");
            bidAmmount = sc.nextInt();
            System.out.print("What color do you wanna bid on: ");
            bid = sc.nextInt();
            bid();
        } while (balance > 0);
        System.out.println("You lost all your life savings");
    }

    public static void Bidding() {

        System.out.println(" 1 = red" + " 2 = black" + " 3 = green");
    }

    public static void bid() {
        hit = randomNumber();
        System.out.print("Rolled: " + hit);
        if (bid == 1) {
            for (int j : red) {
                if (hit == j) {
                    winGreen();
                    return;
                }
            }
            Lose();
        }
        if (bid == 2) {
            for (int j : black) {
                if (hit == j) {
                    Win();
                    return;
                }
            }
            Lose();
        }
        if (bid == 3) {
            for (int j : green) {
                if (hit == j) {
                    Win();
                    return;
                }
            }
            Lose();
        }

    }
    public static void Win() {
        balance += bidAmmount;
        System.out.println(" You win");
    }

    public static void Lose() {
        balance -= bidAmmount;
        System.out.println(" You lost");
    }


    public static void winGreen() {
        balance += bidAmmount * 12;
        System.out.println(" You win");
    }

}