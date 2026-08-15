class Solution {
    public int countWithout(int n, int d) {
        // code here
        if(n<=0)
            return 0;
            
        String s=String.valueOf(n);
        int len=s.length();
        Integer dp[][][]=new Integer[len][2][2];
        
        return compute(0,true,false,s,len,dp,d);
    }
    private int compute(int i,boolean tight,boolean start,String s,
                        int n,Integer dp[][][],int d){
        if(i>=n)
            return start?1:0;
        
        int ti=tight?1:0;
        int si=start?1:0;
        
        if(dp[i][ti][si]!=null)
            return dp[i][ti][si];
        
        int limit=tight?s.charAt(i)-'0':9;
        int cnt=0;
        
        for(int di=0;di<=limit;di++){
            boolean nt=tight && (di==limit);
            if(!start && di==0){
                cnt+=compute(i+1,nt,false,s,n,dp,d);
            }
            else if(di!=d){
                cnt+=compute(i+1,nt,true,s,n,dp,d);
            }
        }
        
        return dp[i][ti][si]=cnt;
    }
}