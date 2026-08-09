class Solution {
    public int zigzagSequence(int[][] mat) {
        // code here
        int res=0,n=mat.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i]=mat[n-1][i];
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int maxi=0;
                
                for(int k=0;k<n;k++){
                    if(k!=j){
                        maxi=Math.max(maxi,dp[i+1][k]);
                    }
                }
                dp[i][j]=mat[i][j]+maxi;
            }
        }
        
        return Arrays.stream(dp[0]).max().orElse(dp[0][0]);
    }
}