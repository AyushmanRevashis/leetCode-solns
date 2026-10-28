class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int ele : weights) {
            max = Math.max(ele, max);
            sum += ele;
        }
        int lo = max;
        int hi = sum;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, days, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currCap = capacity;
        for (int ele : weights) {
            if (currCap < ele) {
                daysNeeded++;
                currCap = capacity;
            } 
                currCap -= ele;
        }
        if (daysNeeded <= days)
            return true;
        else
            return false;
    }
}