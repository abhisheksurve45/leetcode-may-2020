public class FloodFill {

    class Solution {

        private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
            if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) return;
            image[i][j] = newColor;
            dfs(image, i + 1, j, oldColor, newColor);
            dfs(image, i - 1, j, oldColor, newColor);
            dfs(image, i, j + 1, oldColor, newColor);
            dfs(image, i, j - 1, oldColor, newColor);
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] != newColor) dfs(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

    }
}
