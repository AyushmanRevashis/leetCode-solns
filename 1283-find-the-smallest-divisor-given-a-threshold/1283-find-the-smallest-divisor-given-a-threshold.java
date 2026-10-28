class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int ele : nums) {
            max = Math.max(ele, max);
        }
        int lo = 1, hi = max;
        long divisor = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isMax(nums, mid) <= threshold) {
                hi = mid - 1;
                divisor = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;

    }

    private long isMax(int[] nums, int divisor) {
        long requiredDivisor = 0;
        for (int ele : nums) {
            if (ele % divisor == 0) {
                requiredDivisor += (ele / divisor);
            } else {
                requiredDivisor += (ele / divisor) + 1;
            }
        }
        return requiredDivisor;
    }
}