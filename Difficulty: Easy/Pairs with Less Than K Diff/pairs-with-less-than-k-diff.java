class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int j=1,res=0;
        for(int i=0;i<n;i++){
            if(j<=i)
                j=i+1;
            while(j<n && arr[j]-arr[i]<k){
                j++;
            }
            res+=(j-1-i);
        }
        return res;
    }
}
