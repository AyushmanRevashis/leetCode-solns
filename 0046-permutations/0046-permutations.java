class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        boolean[] check = new boolean[n];
        permutations(nums, check, sequence, ans);
        return ans;
    }

    private void permutations(int[] nums, boolean[] check, List<Integer> sequence, List<List<Integer>> ans) {
        int n = nums.length;
        if (sequence.size() == n) {
            List<Integer> copy = new ArrayList<>(sequence);
            ans.add(copy);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                sequence.add(nums[i]);
                check[i] = true;
                permutations(nums, check, sequence, ans);
                sequence.remove(sequence.size() - 1);
                check[i] = false;
            }
        }
    }
}