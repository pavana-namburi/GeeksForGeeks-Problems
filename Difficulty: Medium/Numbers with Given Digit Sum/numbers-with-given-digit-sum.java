class Solution {
    public int countWays(int n, int sum) {
        // code here
        if(n==1){
            if(sum>0 && sum<10)
                return 1;
            return -1;
        }
        
        if((sum==0 && n>1) || (sum>n*9))
            return -1;
            
        int dp[][]=new int[n][sum+1];
        
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
            
        return compute(0,0,n,sum,dp);
    }
    private int compute(int i,int cs,int n,int sum,int dp[][]){
        if(i==n){
            if(cs==sum)
                return 1;
            return 0;
        }
        
        if(cs>sum)
            return 0;
            
        if(dp[i][cs]!=-1)
            return dp[i][cs];
            
        int res=0;
        for(int ne=0;ne<10;ne++){
            if(i==0 && ne==0)
                continue;
            res+=compute(i+1,cs+ne,n,sum,dp);
        }
        
        return dp[i][cs]=res;
    }
};