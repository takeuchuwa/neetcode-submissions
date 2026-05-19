class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image, sr, sc, color, image[sr][sc], new int[image.length][image[0].length]);
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int color, int startingColor, int[][] changed) {
        int rows = image.length;
        int columns = image[0].length;
        if (Math.min(sr, sc) < 0 || sr == rows || sc == columns ||
                changed[sr][sc] == 1 || image[sr][sc] != startingColor) {
            return;
        }
        
        image[sr][sc] = color;
        changed[sr][sc] = 1;
        floodFill(image, sr + 1, sc, color, startingColor, changed);
        floodFill(image, sr - 1, sc, color, startingColor, changed);
        floodFill(image, sr, sc + 1, color, startingColor, changed);
        floodFill(image, sr, sc - 1, color, startingColor, changed);
    }
}