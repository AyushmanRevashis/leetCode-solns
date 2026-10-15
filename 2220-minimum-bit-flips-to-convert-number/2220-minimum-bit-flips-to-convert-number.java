class Solution {
    public int minBitFlips(int start, int goal) {
        int intermediate = start ^ goal;
        int count = 0;
        while (intermediate != 0) {
            intermediate = intermediate & (intermediate - 1);
            count++;
        }
        return count;
    }
}