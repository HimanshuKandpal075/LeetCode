class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        if(oldColor == color){
            return image;
        }

        int n = image.length;
        int m = image[0].length;

        boolean vis[][] = new boolean[n][m];

        helper(image, sr, sc, color, oldColor, vis);

        return image;
    }

    static void helper(int[][] image, int r, int c, int color, int oldColor, boolean vis[][]){
        int n = image.length;
        int m = image[0].length;

        if(r < 0 || r >= n || c < 0 || c >= m || image[r][c] != oldColor || vis[r][c]){
            return;
        }
        image[r][c] = color;
        vis[r][c] = true;

        helper(image, r+1, c, color, oldColor, vis);
        helper(image, r-1, c, color, oldColor, vis);
        helper(image, r, c+1, color, oldColor, vis);
        helper(image, r, c-1, color, oldColor, vis);
        
    }
}