class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < nums.length; j++) {

                int sum = nums[i] + nums[j];
                int difference = 0 - sum;

                if (set.contains(difference)) {
                    List<Integer> iSet = Arrays.asList(nums[i], nums[j], difference);
                    Collections.sort(iSet);
                    list.add(iSet);
                } else {
                    set.add(nums[j]);

                }

            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.addAll(list);

        return answer;
        
    }
}