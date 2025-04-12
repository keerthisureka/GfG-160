// Approach: (DFS Traversal)
// TC: O(m * n)
// SC: O(m * n)
class Solution {
    public static void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        // Base case: check for out-of-bound indices or mismatched color
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) {
            return; // Backtrack if invalid
        }
        // Change the color of the current pixel
        image[x][y] = newColor;

        // Recursively call DFS in all four directions
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // If the starting pixel already has the new color, no need to process
        if(image[sr][sc] == newColor) {
            return image;
        }
        // Call DFS with the original color of the starting pixel
        dfs(image, sr, sc, image[sr][sc], newColor);
        // Return the updated image
        return image;
    }
}