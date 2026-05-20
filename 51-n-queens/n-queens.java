 class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] col = new int[n];

        int[] diag1 = new int[2 * n - 1];

        int[] diag2 = new int[2 * n - 1];

        solve(0, board, ans, n, col, diag1, diag2);

        return ans;
    }

    void solve(int row,
               char[][] board,
               List<List<String>> ans,
               int n,
               int[] col,
               int[] diag1,
               int[] diag2) {

        // Base Case
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            ans.add(current);

            return;
        }

        for (int c = 0; c < n; c++) {

            int d1 = row + c;

            int d2 = row - c + (n - 1);

            // Check if safe
            if (col[c] == 0 && diag1[d1] == 0 &&diag2[d2] == 0) {

                // Place queen
                board[row][c] = 'Q';

                col[c] = 1;
                diag1[d1] = 1;
                diag2[d2] = 1;

                solve(row + 1,board,ans,n,col,diag1,diag2);

                // Backtrack
                board[row][c] = '.';

                col[c] = 0;
                diag1[d1] = 0;
                diag2[d2] = 0;
            }
        }
    }
}