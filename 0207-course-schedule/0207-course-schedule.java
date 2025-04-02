class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> topo = new ArrayList<>();

        // build adjacency matrix
        Map<Integer, List<Integer>> map = new HashMap<>();

        // [1,0] 1 -> 0, 1 must happen before 0. 0 is dependent on 1
        for(int[] arr : prerequisites) {
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                map.put(arr[1], list);
            }
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            List<Integer> list = map.get(i);
            if (list != null) {
                for(int j = 0; j < list.size(); j++) {
                    indegree[list.get(j)]++;
                }
            }
        }

        // if 0 indegree, then no dependencies and can be ordered
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer pop = queue.remove();
            topo.add(pop);
            List<Integer> list = map.get(pop);

            // check adjacent nodes
            if (list != null) {
                for(int i = 0; i < list.size(); i++) {
                    indegree[list.get(i)]--;

                    if (indegree[list.get(i)] == 0) {
                        queue.add(list.get(i));
                    }
                }
            }
        }
       

        if (topo.size() == numCourses) {
            return true;
        }

        return false;

        
    }
}