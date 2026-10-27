
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(b[0], a[0]); 
            }
            return Integer.compare(a[1], b[1]); 
        });

        ArrayList<Integer> width = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] envelope : envelopes) {
            width.add(envelope[0]);
        }

        int n = width.size();
        for (int ele : width) {
            if (ans.size() == 0 || ele > ans.get(ans.size()-1)) {
                ans.add(ele);
            } else {
                replace(ele, ans);
            }
        }
        return ans.size() ;
    }

    public void replace(int ele, ArrayList<Integer> ans) {
        int lo = 0, hi = ans.size() - 1, lb = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (ans.get(mid) >= ele) {
                lb = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        ans.set(lb, ele);
    }
}