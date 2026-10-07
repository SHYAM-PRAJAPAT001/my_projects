public class Leetcode861 {
    public int matrixScore(int[][] grid) {
        
        int score = 0 ; 
        int n = grid.length ; 
        int m = grid[0].length ; 

        for(int row = 0 ; row < n ; row++) {
            
            score += 1 << m - 1 ; 

            if(grid[row][0] == 1) continue ; 

            for(int col = 0 ; col < m ; col++) {
                grid[row][col] ^= 1 ; 
            }
        }


        for(int col = 1 ; col < m ; col++) {
            
            int ones = 0 ; 

            for(int row = 0 ; row < n ; row++) {
                if(grid[row][col] == 1) ones++ ; 
            }

            int max = Math.max(ones, n - ones) ; 

            score += max * (1 << (m - (col + 1))) ; 

        }

        return score ; 

    }

    public static void main(String[] args) {
        Leetcode861 obj = new Leetcode861() ; 
        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}} ; 
        System.out.println(obj.matrixScore(grid));
    }
}