class Solution {
    public String findLongestWord(String s, List<String> d) {
        // code here
        Collections.sort(d,(a,b)->{
            if(a.length()==b.length())
                return a.compareTo(b);
            return b.length()-a.length();
        });
        
        int n=d.size();
        
        for(int i=0;i<n;i++){
            if(canObtain(d.get(i),s))   
                return d.get(i);
        }
        
        return "";
    }
    
    private boolean canObtain(String a,String b){
        int n1=a.length(),n2=b.length();
        if(n1>n2)
            return false;
            
        if(n1==n2)
            return a.equals(b);
            
        int i=0,j=0;
        
        while(i<n1 && j<n2){
            
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else
                j++;
        }
        
        return i>=n1;
    }
}