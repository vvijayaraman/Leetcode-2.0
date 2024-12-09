class Solution {
    public int leastInterval(char[] tasks, int n) {

               int totalTime = 0;

        // Create a map with character and count
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap to keep track of the highest frequency
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());

        // Queue to keep track of tasks waiting for cooldown
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            totalTime++;

            if (!maxHeap.isEmpty()) {
                // Get the task with the highest frequency
                int freq = maxHeap.poll() - 1;

                // If there are still tasks remaining, add them back to the cooldown queue
                if (freq > 0) {
                    queue.add(new Pair<>(freq, totalTime + n));
                }
            }

            // Check if any task in the cooldown queue is ready to be re-added to the heap
            if (!queue.isEmpty() && queue.peek().getValue() == totalTime) {
                maxHeap.add(queue.poll().getKey());
            }
        }

        return totalTime;
    }
}
 