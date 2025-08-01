class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // prefer the ones that have more units per box
        Arrays.sort(boxTypes, ((a, b) -> b[1] - a[1]));
        int maxUnits = 0;

        for(int i = 0; i < boxTypes.length; i++) {
            int noOfBoxes = Math.min(truckSize, boxTypes[i][0]);
            maxUnits += noOfBoxes * boxTypes[i][1];

            // reduce truckSize
            truckSize = truckSize - noOfBoxes;

            if (truckSize == 0) {
                break;
            }

        }

        return maxUnits;

    
    }
}