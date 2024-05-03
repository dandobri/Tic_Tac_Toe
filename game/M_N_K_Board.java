package game;

import java.util.Arrays;
import java.util.Map;

public class M_N_K_Board implements Board, Position{
    public final int m;
    public final int n;
    public final int k;
    public final int count = 0;
    private final Cell[][] field;
    private Cell turn;
    private final Map<Cell, Character> CELL_TO_STRING = Map.of(Cell.X, 'X', Cell.O, 'O', Cell.E, '.');
    public M_N_K_Board(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        field = new Cell[m][n];
        for(Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }
    @Override
    public Position getPosition() {
        return this;
    }
    @Override
    public Result makeMove(Move move) {
        if (!isValid(move)) {
            return Result.UNKNOWN;
        }
        try {
            int pos = 0;
            field[move.getRow()][move.getCol()] = move.getCell();
            for (int c = 0; c < m; c++) {
                for (int r = 0; r < n; r++) {
                    if (field[c][r] == turn) {
                        pos++;
                    } else pos = 0;
                    if (pos == k) {
                        return Result.WIN;
                    }
                }
            }
            //победа по вертикали
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (field[c][r] == turn) {
                        pos++;
                    } else pos = 0;
                    if (pos == k) {
                        return Result.WIN;
                    }
                }
            }
            //победа по горизонтали слева направо
            int s = 0;
            if (m > n) {
                for (int r = 0; r < m - n + 1; r++) {
                    s = 0;
                    pos = 0;
                    for (int c = 0; c < n; c++) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = m - n + 1; r < m; r++) {
                    s = 0;
                    pos = 0;
                    for (int c = 0; c < n - r + 1; c++) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 0; c < n - 1; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = c + 1; r < n; r++) {
                        if (field[s][r] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = 0; r < m - n + 1; r++) {
                    s = 0;
                    pos = 0;
                    for (int c = n - 1; c > -1; c--) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = m - n + 1; r < m; r++) {
                    s = 0;
                    pos = 0;
                    for (int c = n - r + 1; c > 0; c--) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 0; c < n - 1; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = n - c - 1; r > -1; r--) {
                        if (field[s][r] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
            } else if (m == n) {
                for (int r = 0; r < m; r++) {
                    pos = 0;
                    s = 0;
                    for (int c = 0; c < m - r; c++) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 0; c < m - 1; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = c + 1; r < n; r++) {
                        if (field[s][r] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = 0; r < m; r++) {
                    pos = 0;
                    s = 0;
                    for (int c = m - r - 1; c > -1; c--) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 0; c < m - 1; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = c + 1; r < n; r++) {
                        if (field[s][r] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 0; c < n - 1; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = n - c - 1; r > -1; r--) {
                        if (field[s][r] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
            } else if (m < n) {
                for (int c = 0; c < n - m + 1; c++) {
                    s = c;
                    pos = 0;
                    for (int r = 0; r < m; r++) {
                        if (field[r][s] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = 1; r < m; r++) {
                    s = 0;
                    pos = 0;
                    for (int c = 0; c < m - r; c++) {
                        if (field[r + s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 1; c < m; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = 0; r < m - c; r++) {
                        if (field[r][n - m + c + s] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int c = 0; c < n - m + 1; c++) {
                    s = 0;
                    pos = 0;
                    for (int r = n - c - 1; r > n - m - c - 1; r--) {
                        if (field[s][r] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = 1; r < m; r++) {
                    s = 0;
                    pos = 0;
                    for (int c = n - m + r; c < n; c++) {
                        if (field[m - 1 - s][c] == turn) {
                            pos++;
                        } else pos = 0;
                        s++;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
                for (int r = n - m + 1; r < n; r++) {
                    pos = 0;
                    for (int c = 0; c < m - 1; c++) {
                        if (field[c][n - 1 - r] == turn) {
                            pos++;
                        } else pos = 0;
                        if (pos == k) {
                            return Result.WIN;
                        }
                    }
                }
            }
            turn = turn == Cell.X ? Cell.O : Cell.X;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("your number is too high");
            return Result.LOSE;
        }
        int empty = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(field[r][c] == Cell.E) {
                    empty++;
                }
            }
        }
        return empty > 0 ? Result.UNKNOWN : Result.DRAW;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    public boolean isValid(Move move) {
        if(move.getRow() < m && move.getCol() < n) {
            return
                    field[move.getRow()][move.getCol()] == Cell.E &&
                    move.getCell() == turn;
        } else return true;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("  ");
        for(int c  = 0; c < n; c++) {
            sb.append(c + 1);
        }
        sb.append("\n +");
        for(int i = 0; i < n; i++) {
            if((i + 1) / 10 == 0) {
                sb.append("-");
            } else sb.append("--");
        }
        sb.append("\n");
        for(int r = 0; r < m; r++) {
            sb.append(r + 1).append("|");
            for(int c = 0; c < n; c++) {
                sb.append(CELL_TO_STRING.get(field[r][c]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
