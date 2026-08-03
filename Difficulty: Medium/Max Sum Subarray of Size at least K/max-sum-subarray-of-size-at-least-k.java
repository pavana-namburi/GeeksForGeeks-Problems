class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int n=arr.length;
        int cs=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<n;i++){
            cs+=arr[i];
            hm.put(i,cs);
        }
        
        int res=hm.get(k-1),min=0;
        for(int j=k;j<n;j++){
            min=Math.min(min,hm.get(j-k));
            res=Math.max(res,hm.get(j)-min);
        }
        
        return res;
    }
}