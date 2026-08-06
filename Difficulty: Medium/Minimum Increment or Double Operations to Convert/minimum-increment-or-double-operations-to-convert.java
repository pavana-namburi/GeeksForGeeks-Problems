class Solution {
	public int countMinOperations(int arr[]) {
		// code here
		int n = arr.length;
		int res=0,d=0;
		for(int i=0;i<n;i++){
		    if(arr[i]==0)
		        continue;
		    res+=Integer.bitCount(arr[i]);
		    d=Math.max(d,31-Integer.numberOfLeadingZeros(arr[i]));
		}
		return res+d;
	}
}
