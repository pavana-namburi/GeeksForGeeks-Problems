class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n=h.length;
        if(n==1)
            return h[0];
            
        int dp[]=new int[n+1];
        dp[1]=Math.max(h[0],l[0]);
        
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-2]+h[i-1],dp[i-1]+l[i-1]);
        }
        return dp[n];
    }
}