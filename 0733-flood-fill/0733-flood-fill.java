class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        if(oldColor == color){
            return image;
        }

        int n = image.length;
        int m = image[0].length;

        boolean vis[][] = new boolean[n][m];
        
        int[][] ans = image.clone();

        ans[sr][sc] = color;

        helper(image, sr, sc, color, oldColor, vis, ans);

        return ans;
    }

    static void helper(int[][] image, int r, int c, int color, int oldColor, boolean vis[][], int[][] ans){
        int n = image.length;
        int m = image[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        vis[r][c] = true;

        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR >= 0 && nR < n &&
                nC >= 0 && nC < m &&
                image[nR][nC] == oldColor
                && !vis[nR][nC]){
                    ans[nR][nC] = color;
                    helper(image, nR, nC, color, oldColor, vis, ans);
                }
        }
    }
}