class Solution { 
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) { 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); 
        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (mat[i][j] == word.charAt(0)) { 
                    for (int dir = 0; dir < 8; dir++) {
                        if (checkDirection(i, j, n, m, mat, word, dx[dir], dy[dir])) {
                            ArrayList<Integer> al = new ArrayList<>(); 
                            al.add(i);
                            al.add(j); 
                            res.add(al);
                            break; 
                        }
                    }
                } 
            } 
        } 
        return res; 
    } 

    private boolean checkDirection(int r, int c, int n, int m, char[][] mat, String word, int kx, int ky) {
        for (int idx = 0; idx < word.length(); idx++) {
            int nextR = r + idx * kx;
            int nextC = c + idx * ky;

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                return false;
            }

            if (mat[nextR][nextC] != word.charAt(idx)) {
                return false;
            }
        }
        return true;
    }
}
