class Solution {
    static final int mod=1000000007;
    public int palindromicStrings(int n, int k) {
        // code here
        long res=0;
        for(int l=1;l<=n;l++){
            int Uchars=(l+1)/2;
            
            long p=1;
            for(int i=1;i<=Uchars;i++){
                p+=(p*(k-i))%mod;
            }
            
            res=(res+p)%mod;
        }
        return (int)res;
    }
}