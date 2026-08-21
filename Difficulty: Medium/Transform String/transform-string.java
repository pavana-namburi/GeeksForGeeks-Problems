class Solution {
    int transform(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n != m)
            return -1;

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            hm.put(a, hm.getOrDefault(a, 0) + 1);
            hm.put(b, hm.getOrDefault(b, 0) - 1);
        }

        for (int x : hm.values()) {
            if (x != 0)
                return -1;
        }

        int res = 0;
        int i = n - 1;
        int j = n - 1;

        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                res++;
                i--; 
            }
        }

        return res;
    }
}
