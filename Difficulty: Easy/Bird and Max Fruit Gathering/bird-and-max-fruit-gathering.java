class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int n=arr.size();
        int cs=0,res=0;
        
        for(int i=0;i<m;i++){
            cs+=arr.get(i);
        }
        res=cs;
        
        int j=1;
        while(j!=0){
            cs+=arr.get((j+m-1)%n);
            cs-=arr.get(((j-1)+n)%n);
            res=Math.max(res,cs);
            j=(j+1)%n;
        }
        
        return res;
    }
}