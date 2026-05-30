 class Solution {

    int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific
        for(int c=0;c<n;c++) {
            dfs(0,c,pacific,heights);
            dfs(m-1,c,atlantic,heights);
        }

        // Atlantic
        for(int r=0;r<m;r++) {
            dfs(r,0,pacific,heights);
            dfs(r,n-1,atlantic,heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                if(pacific[i][j] && atlantic[i][j]) {

                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void dfs(
            int r,
            int c,
            boolean[][] visited,
            int[][] heights) {

        if(visited[r][c])
            return;

        visited[r][c] = true;

        int m = heights.length;
        int n = heights[0].length;

        for(int[] d : directions) {

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nr >= m ||
               nc < 0 || nc >= n)
                continue;

            if(heights[nr][nc] >= heights[r][c]) {

                dfs(nr,nc,visited,heights);
            }
        }
    }
}