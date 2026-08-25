class Solution {
    public int minMoves(int[] arr) {
        // code here
        int ml=1,cnt=1,n=arr.length;
        int pos[]=new int[n+1];
        
        for(int i=0;i<n;i++){
            pos[arr[i]]=i;
        }
        
        for(int i=2;i<=n;i++){
            if(pos[i]>pos[i-1])
                cnt++;
            else{
                cnt=1;
            }
            ml=Math.max(ml,cnt);
        }
        return n-ml;
    }
}