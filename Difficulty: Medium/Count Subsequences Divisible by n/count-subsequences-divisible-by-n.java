class Solution {
    public int countSubsequences(String s, int n) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n];

        for (char c : s.toCharArray()) {
            int d = c - '0';
            long[] newdp = dp.clone(); // case: digit not taken

            // extend all existing subsequences with this digit
            for (int r = 0; r < n; r++) {
                if (dp[r] == 0) continue;
                int nr = (int) ((r * 10L + d) % n);
                newdp[nr] = (newdp[nr] + dp[r]) % MOD;
            }

            // new subsequence consisting of this single digit
            int dr = d % n;
            newdp[dr] = (newdp[dr] + 1) % MOD;

            dp = newdp;
        }

        return (int) dp[0];
    }
}