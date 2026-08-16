class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int negCount = 0;
        int zeroCount = 0;
        int posCount = 0;

        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
            else if (arr[i] < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, arr[i]);
            }
            else {
                posCount++;
                minPos = Math.min(minPos, arr[i]);
            }
        }
        
        if (zeroCount == n){
            return 0;
        }

        if (negCount == 0) {
            if(zeroCount>0)
                return 0;
            return minPos;
        }

        int prod = 1;
        boolean skipMaxNeg = (negCount % 2 == 0);

        for (int i = 0; i < n; i++) {
            
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i] < 0) {
                if (arr[i] == maxNeg && skipMaxNeg) {
                    skipMaxNeg = false;
                    continue;
                }
            }
            prod = prod * arr[i];
        }

        return prod;
    }
}
