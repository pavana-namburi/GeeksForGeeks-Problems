class Solution {
    public int solve(int n, String s) {
        // code here
        int res=0;
        HashSet<Character> hs=new HashSet<>();
        HashSet<Character> r=new HashSet<>();
        int len=s.length();
        for(int i=0;i<len;i++){
            if(!hs.contains(s.charAt(i)) && !r.contains(s.charAt(i))){
                if(n>0){
                    n--;
                    hs.add(s.charAt(i));
                }
                else{
                    res++;
                    r.add(s.charAt(i));
                }
                
            }
            else if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                n++;
            }
            else if(r.contains(s.charAt(i))){
                r.remove(s.charAt(i));
            }
        }
        
        return res;
    }
}
