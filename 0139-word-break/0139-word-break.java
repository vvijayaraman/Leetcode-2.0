class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Bottom up DP solution (Starting from last position)
        boolean[] dp = new boolean[s.length() + 1]; 
        dp[dp.length - 1] = true;

        // Convert List to Set for easy look up
        Set<String> set = new HashSet<>(); 
        for (String st : wordDict) {
            set.add(st);
        }
        
        //    l      e      e      t     c      o      d      e         ]
        // [false, false, false, false, false, false, false, false, true]

        // Keep track of - can you build the substring from the place where dp says true


        for(int i = dp.length - 2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {

                String substring = s.substring(j, i+1);
                if (dp[j + substring.length()] == true && set.contains(substring)) {
                    dp[j] = true;
                }
            }
        }

       
        return dp[0] == true;
        
    }
}