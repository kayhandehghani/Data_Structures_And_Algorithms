class DP {

    // Longest Common Substring
    public static String LCS(String s1, String s2) {
        if (s1.length() > 0 && s2.length() > 0) {
            String[][] table = new String[s1.length() + 1][s2.length() + 1];
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 || j == 0) {
                        table[i][j] = "";
                    } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        table[i][j] =  table[i - 1][j - 1] + s1.charAt(i - 1);
                    } else {
                        if (table[i][j - 1].length() > table[i - 1][j].length()) {
                            table[i][j] = table[i][j - 1];
                        } else {
                            table[i][j] = table[i - 1][j];
                        }
                    }
                }
            }
            return table[s1.length()][s2.length()];
        } else {
            return "";
        }
    }

}

