class Solution {
    public int maxArea(int[][] mat) {
        // code here
        int n=mat.length,m=mat[0].length;
        int hist[][]=new int[n][m];
        
        hist[0][0]=mat[0][0];
        
        for (int j = 0; j < m; j++) {
            hist[0][j] = mat[0][j];
        }
        
        for(int i=1;i<n;i++){
            if(mat[i][0]==1)
                hist[i][0]=hist[i-1][0]+1;
            else
                hist[i][0]=0;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]==1){
                    hist[i][j]=1+hist[i-1][j];
                }
                else{
                    hist[i][j]=0;
                }
            }
        }
        
        for (int[] row : hist) {
            Arrays.sort(row);
            int i = 0, j = row.length - 1;
            while (i < j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
        
        int res=0;
        for(int row[]:hist){
            for(int i=0;i<row.length;i++){
                if(row[i]==0)
                    break;
                
                int ca=row[i]*(i+1);
                res=Math.max(res,ca);
            }
        }
        
        return res;
    }
}