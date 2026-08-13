class pair{
    int val,w;
    pair(int a,int b){
        val=a;
        w=b;
    }
}

class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // code here
         ArrayList<ArrayList<pair>> g=new ArrayList<>();
         
         for(int i=0;i<V;i++)
            g.add(new ArrayList<>());
            
         for(ArrayList<Integer> x:edges){
             g.get(x.get(0)).add(new pair(x.get(1),x.get(2)));
         }  
         
         Queue<pair> q=new LinkedList<>();
         q.add(new pair(src,0));
         int res[]=new int[V];
         Arrays.fill(res,Integer.MIN_VALUE);
         res[src]=0;
         
         while(!q.isEmpty()){
             pair p=q.poll();
             for(pair x:g.get(p.val)){
                 if( p.w+x.w > res[x.val]){
                     res[x.val]= p.w+x.w;
                     q.add(new pair(x.val,p.w+x.w));
                 }
             }
         }
         
         return res;
    }
}
