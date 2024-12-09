class Solution {
    public int getLargestOutlier(int[] nums) {
        // sum(n-2) + special number + outlier = sum(array)
        // x + x + outlier = sum(array)
        // 2x + outlier = sum(array)
        // x = sum(array) - outlier / 2
        // if x exists - then I could be an outlier

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int outlier = Integer.MIN_VALUE;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }

        for(int num : nums) {

            // if i am not divisble by 2, then i cannot be an asnwer
            if ((sum - num) % 2 != 0) {
                continue;
            }           

            // consider me as the outlier
            int specialNo = (sum - num) / 2;

            if (map.containsKey(specialNo)) {
                
                // Edge case: when specialNo equals outlier (like double the total sum case)
                if (specialNo == num && map.get(specialNo) < 2) {
                    continue; // We need at least two occurrences of the special number
                }

                outlier = Math.max(num, outlier); // I could be an outlier
            }

        }

        return outlier;
        
        
    }
}