/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        getLeafs(root,1,pq);
        int cnt=0;
        
        while(!pq.isEmpty() && k-pq.peek()>=0){
            k-=pq.poll();
            cnt++;
        }
        
        return cnt;
    }
    private void getLeafs(Node root,int level,PriorityQueue<Integer> pq){
        
        if(root.left==null && root.right==null)
            pq.add(level);
            
        if(root.left!=null)
            getLeafs(root.left,level+1,pq);
        
        if(root.right!=null)
            getLeafs(root.right,level+1,pq);
    }
}