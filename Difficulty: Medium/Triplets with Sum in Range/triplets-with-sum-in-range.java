class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        // code here
        Arrays.sort(arr);
        return count(arr,r+1)-count(arr,l);
    }
    private int count(int arr[],int t){
        int n=arr.length;
        int res=0;
        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            while(j<k){
                int s=arr[i]+arr[j]+arr[k];
                if(s<t){
                    res+=k-j;
                    j++;
                }
                else
                    k--;
            }
        }
        return res;
    }
}