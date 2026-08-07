class Solution {
    public int countFriendsPairings(int n) {
        // code here
        if(n==1)
            return 1;
        return compute(n-1)+(n-1)*compute(n-2);
        
    }
    private int compute(int n){
        if(n==1 || n==0)
            return 1;
        return compute(n-1)+(n-1)*compute(n-2);
    }
}
