class Solution {
    public boolean isPowerOfTwo(int n) {
        long power = 1;
        while (power < n) {
            power = power * 2;
        }
        return power == n;

    }
}