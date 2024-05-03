package game;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HumanPlayer implements Player, Position{
    private final Scanner in;
    private final PrintStream out;

    public HumanPlayer(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public HumanPlayer() {
        this(new Scanner(System.in), System.out);
    }

    @Override
    public Move move(Position position) {
        System.out.println("Position: ");
        System.out.println(position);
        System.out.println("Enter row and column");
        int[] arr = new int[2];
        int count = 0;
        do {
            try {
                int s = in.nextInt() - 1;
                arr[count] = s;
                count++;
            } catch(InputMismatchException e) {
                System.out.println("your number in false format");
                in.next();
            }
        } while(count < 2);
        return new Move(arr[0], arr[1], position.getTurn());
    }
    @Override
    public Cell getTurn() {
        return null;
    }

    @Override
    public boolean isValid(Move move) {
        return false;
    }
}
