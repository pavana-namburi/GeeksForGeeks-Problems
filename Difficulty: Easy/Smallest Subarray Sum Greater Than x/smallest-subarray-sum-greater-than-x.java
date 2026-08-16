class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        // code here
        int n=arr.length;
        int j=0,i=0,cs=0;
        int res=Integer.MAX_VALUE;
        
        while(i<n){
            cs+=arr[i];
            while(cs>x){
                res=Math.min(res,i-j+1);
                cs-=arr[j];
                j++;
            }
            i++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
