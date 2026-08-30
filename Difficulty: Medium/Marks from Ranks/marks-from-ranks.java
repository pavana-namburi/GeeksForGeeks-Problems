class pair{
    int rank,i;
    pair(int rank,int i){
        this.rank=rank;
        this.i=i;
    }
}
class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here
        int n=l.length,rnk=0;
        int m=rank.length;
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.rank-b.rank);
        ArrayList<Integer> res=new ArrayList<Integer>();
        
        for(int i=0;i<m;i++){
            pq.add(new pair(rank[i],i));
            res.add(0);
        }
        
        
        for(int i=0;i<n;i++){
            int t=r[i]-l[i]+1; 
            
            while(!pq.isEmpty() && rnk<pq.peek().rank && pq.peek().rank<=rnk+t){
                res.set(pq.peek().i,l[i]+pq.peek().rank-rnk-1);
                pq.poll();
            }
            
            rnk+=t;
            if(pq.isEmpty())
                break;
        }
        
        return res;
    }
   
}