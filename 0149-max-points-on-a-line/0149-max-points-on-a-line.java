class Solution {
    public int maxPoints(int[][] points) {

        // 1. 2 point that have same slope are on a straight line
        // 2. Points on a vertical line (same x axis) are infinity - edge case
        // 3. Store same slops - count in a map

        if (points.length == 1) {
            return 1;
        }
        

        Map<Double, Integer> map = new HashMap<>();
        int max = 0;

        for(int i = 0; i < points.length - 1; i++) {
            int[] first = points[i];
            for(int j = i + 1; j < points.length; j++) {
                int[] second = points[j];
                double slope = calculateSlope(first[0], first[1], second[0], second[1]);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }

            map.clear();
        } 

        return max + 1;
        
    }

    public double calculateSlope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Double.MAX_VALUE;
        }

        if (y1 == y2) {
            return 0.0;
        }

        return (double) (y2 - y1) / (double) (x2 - x1);
    }
 }