class Solution {
    public int minIncrementForUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for(int num : nums) {
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int moves = 0;

        // The iterations are always n + maximum value
        // Example [7,7,7,7,7,7,7]
        // [7,8,9,10,11,12,13] so you'll need the loop to run from o - 13 so you don't miss iterating the end

        for(int i = 0; i < nums.length + max; i++) {
            if (!map.containsKey(i)) {
                continue;
            }

            if (map.get(i) > 1) { // carry over the rest to the next value
                int carry = map.get(i) - 1; // keep 1 and carry over rest
                map.put(i+1, map.getOrDefault(i+1, 0) + carry);
                moves += carry;

            } 
          
        }

        return moves;


        
    }
}