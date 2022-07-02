class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        int units = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize >= boxTypes[i][0]) {
                units += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0]; 
            } else {
                units += truckSize * boxTypes[i][1];
                break;
            }
        }
        return units;
    }
}