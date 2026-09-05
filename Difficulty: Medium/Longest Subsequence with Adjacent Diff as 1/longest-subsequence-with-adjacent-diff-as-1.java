class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=0;
        
        for(int i:arr){
            int l1=hm.getOrDefault(i-1,0);
            int l2=hm.getOrDefault(i+1,0);
            
            int cl=1+Math.max(l1,l2);
            hm.put(i,Math.max(hm.getOrDefault(i,0),cl));
            
            res=Math.max(res,cl);
        }
        
        return res;
    }
}
