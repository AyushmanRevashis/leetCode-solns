class Solution {
  public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, max = 0;
        for (int ele : piles) {
            max = Math.max(ele, max);
        }
        int hi = max;
        long speed = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hours(piles, mid) <= h) {
                hi = mid - 1;
                speed = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private long hours(int[] piles, int speed) {
        long hourRequired = 0;
        for (int ele : piles) {
            if (ele % speed == 0) {
                hourRequired += (ele / speed);
            } else {
                hourRequired += ((ele / speed) + 1);
            }
        }
        return hourRequired;
    }
}