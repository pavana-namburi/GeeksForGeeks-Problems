class pair {
	int r, d;
	pair() {
		r = 0;
		d = 0;
	}
}
class Solution {
	public int largestSubsquare(char mat[][]) {
		// code here
		int n = mat.length;
		
		pair g[][] = new pair[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				pair p = new pair();
				
				if (mat[i][j] == 'X') {
					p.r = 1;
					p.d = 1;
					
					if (j + 1<n) {
						p.r += g[i][j + 1].r;
					}
					
					if (i + 1<n) {
						p.d += g[i + 1][j].d;
					}
				}
				
				g[i][j] = p;
			}
		}
		
		int res = 0;
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
			    
				int s = Math.min(g[i][j].r, g[i][j].d);
				
				for (int k = s; k>res; k--) {
					int b = i + k - 1;
					int r = j + k - 1;
					
					if (g[b][j].r >= k && g[i][r].d >= k) {
						res = k;
						break;
					}
				}
				
			}
		}
		
		return res;
		
	}
};
