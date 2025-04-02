class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // [0,1] 1->0. 0 is dependent on 1

        Map<Integer, List<Integer>> map = new HashMap<>();

        // adjacency matrix
        for(int[] arr : prerequisites) {
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                map.put(arr[1], new ArrayList<>());
                map.get(arr[1]).add(arr[0]);
            }
        }

        List<Integer> topo = new ArrayList<>();

        // Mark incoming edges, meaning my depdendencies
        int[] indegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            List<Integer> list = map.get(i);
            if (list != null) {
                for(int j = 0; j < list.size(); j++) {
                    indegrees[list.get(j)]++;
                }
            }
        }
          

        Queue<Integer> queue = new LinkedList<>();

        // if indegree 0, start BFS. No incoming edge so no dependency
        for(int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer pop = queue.remove();
            topo.add(pop);

            // Traverse adjacent nodes and reduce 1
            List<Integer> list = map.get(pop);
            if (list != null) {
            for(int i = 0; i < list.size(); i++) {
                indegrees[list.get(i)]--;

                if (indegrees[list.get(i)] == 0) {
                    queue.add(list.get(i));
                }
            } 

            }
        }
        
        int pointer = 0;
       if (numCourses == topo.size()) {
        int[] arr = new int[topo.size()];
        for (int num : topo) {
            arr[pointer] = num;
            pointer++;
        }

        return arr;
       
       }

       return new int[0];

        
    }
}