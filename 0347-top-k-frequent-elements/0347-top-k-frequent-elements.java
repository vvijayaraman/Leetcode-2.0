class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // min heap cause you want to keep removing the minimum. At the end you'll be left w/ max
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()) {
            queue.add(num);

            if (queue.size() > k) {
                queue.remove();
            }
        }
    

        int[] ans = new int[k];
        int index = 0;

        while(k > 0) {
            k--;
            ans[index++] = queue.poll();
        }

        return ans;
        
    }
} 