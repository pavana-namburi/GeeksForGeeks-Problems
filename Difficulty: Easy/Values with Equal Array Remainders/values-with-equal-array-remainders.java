class Solution {
	public int sameMod(int[] arr) {
		// code here
		int n = arr.length;
		boolean allEqual = true;
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[0]) {
				allEqual = false;
				break;
			}
		}
		if (allEqual)
			return - 1;
		
		int minVal = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] < minVal) {
				minVal = arr[i];
			}
		}
		
		int g = 0;
		for (int x : arr) {
			if (x != minVal) {
				g = gcd(g, x - minVal);
			}
		}
		
		int count = 0;
		int sqrtG = (int) Math.sqrt(g);
		for (int i = 1; i <= sqrtG; i++) {
			if (g % i == 0) {
				if (i * i == g) {
					count += 1;
				} else {
					count += 2;
				}
			}
		}
		
		return count;
	}
	
	private int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
