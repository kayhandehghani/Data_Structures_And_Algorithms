class DPTest {

    public static void main(String[] args) {
        System.out.println("LCS test returned: " + testLCS());
    }

    public static boolean testLCS() {
        return
            DP.LCS("ABCDGH", "AEDFHR").equals("ADH") &&
            DP.LCS("AGGTAB", "GXTXAYB").equals("GTAB");

    }
}

