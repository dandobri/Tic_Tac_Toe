package game;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int count = 0;
        do {
            try {
                int s = sc.nextInt();
                arr[count] = s;
                count++;
            } catch(InputMismatchException e) {
                System.out.println("your number in false format");
                sc.next();
            }
        } while(count < 3);
        int win = sc.nextInt();
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        Matches match = new Matches(player1, player2, arr[0], arr[1], arr[2], win);
        while(true) {
            match.Games();
        }
    }
}