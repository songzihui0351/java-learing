package Hot100;

public class WordSearch_79 {
    public static void main(String[] args) {
        WordSearch_79 solution = new WordSearch_79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABFCED";
        System.out.println(solution.exist(board, word));
    }

    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean found = backTrack(i, j, 0, visited, board, word);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(int i, int j, int k, boolean[][] visited, char[][] board, String word) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean found = false;
        for (int[] direction : directions) {
            int nextI = i + direction[0], nextJ = j + direction[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < board.length && nextJ < board[0].length) {
                if (!visited[nextI][nextJ]) {
                    boolean flag = backTrack(nextI, nextJ, k + 1, visited, board, word);
                    if (flag) {
                        found = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return found;
    }
}
