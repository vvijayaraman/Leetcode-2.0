class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0; // number of times candidate 1 appear or disappear
        int count2= 0; // number of times candidate 2 appear or disappear

        for(int num : nums) {

            // Need to take care of an edge case where candidate1 and candidate2 are not the same number
            if (count1 == 0 && candidate2 != num) {
                candidate1 = num;
            } else if (count2 == 0 && candidate1 != num) {
                candidate2 = num;
            }

            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }

        }

        int answer1 = 0;
        int answer2 = 0;

        for(int num : nums) {
            if (num == candidate1) {
                answer1++;
            } else if (num == candidate2) {
                answer2++;
            }
        }

        if (answer1 > Math.floor(nums.length / 3)) {
            list.add(candidate1);
        }

         if (answer2 > Math.floor(nums.length / 3)) {
            list.add(candidate2);
        }


        return list;

        
    }
}