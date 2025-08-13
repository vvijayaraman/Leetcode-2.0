class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int left = i;
            int right = i + 1;

            while(right < nums.length && nums[right] - nums[left] == 1) {
                left++;
                right++;
            }

            StringBuilder st = new StringBuilder();

            if (nums[i] != nums[left]) {
                st.append(String.valueOf(nums[i]));
                st.append("->");
                st.append(String.valueOf(nums[left]));

                list.add(st.toString());
            } else {
                st.append(String.valueOf(nums[i]));

                list.add(st.toString());

            }
          

            i = left++;

        }

        return list;
        
    }
}