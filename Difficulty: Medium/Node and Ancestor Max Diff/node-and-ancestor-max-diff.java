/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int max=Integer.MIN_VALUE;
    int maxDiff(Node root) {
        //  code here
        compute(root);
        return max;
    }
    private int compute(Node curr){
        
        int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;
        
        if(curr.left!=null) {
            x=compute(curr.left);
            max=Math.max(max,curr.data-x);
        }
        
        if(curr.right!=null){
            y=compute(curr.right);
            max=Math.max(max,curr.data-y);
        }    

        return Math.min(curr.data,Math.min(x,y));    
    }
}