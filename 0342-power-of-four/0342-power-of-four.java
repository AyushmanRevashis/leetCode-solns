class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return ((n & (n - 1)) == 0);

    }

    public boolean isPowerOfFour(int n) {
        return isPowerOfTwo(n) && isSqrt(n);
    }

    public boolean isSqrt(int n) {
        int root = (int)Math.sqrt(n);
        return (root * root == n);
    }
}