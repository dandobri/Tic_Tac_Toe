package game;

public class Matches {
    private Player player1;
    private Player player2;
    private final int m;
    private final int n;
    private final int k;
    private int win1 = 0;
    private int win2 = 0;
    private int win;
    public Matches(Player player1, Player player2, int m, int n, int k, int win) {
        this.player1 = player1;
        this.player2 = player2;
        this.win = win;
        this.m = m;
        this.n = n;
        this.k = k;
    }
    public void Games() {
        Game game = new Game(player1, player2, true);
        int s;
        Player player;
        M_N_K_Board board = new M_N_K_Board(m, n, k);
        int pro = game.play(board);
        if(pro == 1) {
            win1++;
        } else if(pro == 2) {
            win2++;
        }
        if(win1 == win) {
            System.out.println("first player win");
            System.exit(0);
        } else if(win2 == win) {
            System.out.println("second player win");
            System.exit(0);
        }
        s = win1;
        win1 = win2;
        win2 = s;
        player = player1;
        player1 = player2;
        player2 = player;
    }
}