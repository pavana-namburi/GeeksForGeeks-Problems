class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        // code here
        return subCount(arr,r)-subCount(arr,l-1);
    }
    private int subCount(int arr[],int k){
        int j=0,n=arr.length;
        long res=0,cs=0;
        for(int i=0;i<n;i++){
            cs+=arr[i];
            while(j<=i && cs>k){
                cs-=arr[j];
                j++;
            }
            res+=i-j+1;
        }
        return (int)res;
    }
}