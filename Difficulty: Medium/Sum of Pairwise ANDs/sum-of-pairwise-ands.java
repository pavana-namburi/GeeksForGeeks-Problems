class Solution {
    public long pairAndSum(int[] arr) {
        // code here
        int n=arr.length;
        long res=0;
        
        for(int i=0;i<32;i++){
            long cnt=0;
            for(int j:arr){
                if((1&(j>>i))==1)
                    cnt++;
            }
            res+=((cnt*(cnt-1)/2)*(1L<<i));
        }
        
        return res;
    }
}