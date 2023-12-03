import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Character.isDigit;

public class ValidSudoku {
    public static void main(String[] argv) {
        char[][] table = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        ValidSudoku solution = new ValidSudoku();
        System.out.println(solution.isValidSudoku(table));
    }

    public static int mapper(int i){
        if (i < 3)
            return 0;
        if (i >= 6)
            return 6;
        else
            return 3;
    }

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowTable = new ArrayList<>();
        List<Set<Character>> colTable = new ArrayList<>();
        List<Set<Character>> blockTable = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rowTable.add(new HashSet<>());
            colTable.add(new HashSet<>());
            blockTable.add(new HashSet<>());
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (isDigit(board[i][j])) {
                    if (rowTable.get(i).contains(board[i][j]))
                        return false;
                    else
                        rowTable.get(i).add(board[i][j]);

                    if (colTable.get(j).contains(board[i][j]))
                        return false;
                    else
                        colTable.get(j).add(board[i][j]);

                    if (blockTable.get(mapper(i) + j/3).contains(board[i][j]))
                        return false;
                    else
                        blockTable.get(mapper(i) + j/3).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
