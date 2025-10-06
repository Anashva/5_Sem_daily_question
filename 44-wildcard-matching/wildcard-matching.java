class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()][p.length()];
        for(Boolean[] a:dp ){
            Arrays.fill(a,null);
        }
        return match(s, p, 0, 0,dp);
    }

    public boolean match(String s, String p, int i, int j,Boolean[][]dp) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }

        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean flag = false;
        boolean f2 = false;

        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            f2 = match(s, p, i + 1, j + 1,dp);
        } else if (p.charAt(j) == '*') {
            flag = match(s, p, i, j + 1,dp) || match(s, p, i + 1, j,dp);
        }

        return dp[i][j]=flag || f2;
    }
}
