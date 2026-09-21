/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node r1, Node r2) {
        // code here
        Queue<Node> q1=new LinkedList<>();
        Queue<Node> q2=new LinkedList<>();
        
        if(r1!=null)
            q1.add(r1);
            
        if(r2!=null)
            q2.add(r2);
            
        while(!q1.isEmpty() && !q2.isEmpty()){
            int n1=q1.size();
            int n2=q2.size();
            
            if(n1!=n2)
                return false;
            
            HashMap<Integer,Integer> tm=new HashMap<>();
            
            for(int i=0;i<n1;i++){
                tm.put(q1.peek().data,tm.getOrDefault(q1.peek().data,0)+1);
                
                if(tm.get(q1.peek().data)==0)
                    tm.remove(q1.peek().data);
                    
                tm.put(q2.peek().data,tm.getOrDefault(q2.peek().data,0)-1);
                
                if(tm.get(q2.peek().data)==0)
                    tm.remove(q2.peek().data);
                    
                Node a=q1.poll();
                if(a.left!=null)
                    q1.add(a.left);
                    
                if(a.right!=null)
                    q1.add(a.right);
                    
                Node b=q2.poll();
                if(b.left!=null)
                    q2.add(b.left);
                    
                if(b.right!=null)
                    q2.add(b.right);
                    
            }
            
            if(tm.size()>0)
                return false;
            
        }
        
        if(q1.isEmpty() && q2.isEmpty())
            return true;
            
        return false;
    }
}
