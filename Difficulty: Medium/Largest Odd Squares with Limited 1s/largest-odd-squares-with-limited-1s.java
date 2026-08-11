class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] pre = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = mat[i - 1][j - 1] 
                            + pre[i - 1][j] 
                            + pre[i][j - 1] 
                            - pre[i - 1][j - 1];
            }
        }
        
        for (int[] x : queries) {
            al.add(compute(x[0], x[1], n, m, k, pre));
        }
        
        return al;
    }
    
    private int compute(int x, int y, int n, int m, int k, int[][] pre) {
        if (x < 0 || x >= n || y < 0 || y >= m) 
            return -1; 
        
        int maxSide = 0;
        int maxRadius = Math.min(Math.min(x, n - 1 - x), Math.min(y, m - 1 - y));
        
        for (int t = 0; t <= maxRadius; t++) {
            int r1 = x - t, c1 = y - t;
            int r2 = x + t, c2 = y + t;
            
            int totalOnes = pre[r2 + 1][c2 + 1] 
                          - pre[r1][c2 + 1] 
                          - pre[r2 + 1][c1] 
                          + pre[r1][c1];
            
            if (totalOnes <= k) {
                maxSide = 2 * t + 1;
            } else {
                break;
            }
        }
        
        return maxSide==0?-1:maxSide;
    }
}
