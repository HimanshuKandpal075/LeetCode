class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            helper(heights, pacific, i, 0);
            helper(heights, atlantic, i, m-1);
        }

        for(int j=0;j<m;j++){
            helper(heights, pacific, 0, j);
            helper(heights, atlantic, n-1, j);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    static void helper(int[][] heights, boolean[][] vis, int r, int c){
        int n = heights.length;
        int m = heights[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        vis[r][c] = true;

        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR < 0 || nR >= n || nC < 0 || nC >= m){
                continue;
            }

            if(heights[nR][nC] < heights[r][c]){
                continue;
            }

            if(vis[nR][nC]){
                continue;
            }

            helper(heights, vis, nR, nC);
        }
    }
}

