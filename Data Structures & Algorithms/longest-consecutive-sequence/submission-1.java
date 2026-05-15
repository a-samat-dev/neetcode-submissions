class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        int minNum = nums[0];
        int maxNum = nums[0];

        for (int n : nums) {
            set.add(n);
            minNum = Math.min(n, minNum);
            maxNum = Math.max(n, maxNum);
        }

        int[] arr = new int[maxNum - minNum + 1];

        for (int i = 0; i < arr.length; i++) {
            int currNum = minNum + i;

            if (set.contains(currNum)) {
                int currCount = 1 + (i == 0 ? 0 : arr[i - 1]);
                arr[i] = currCount;
                max = Math.max(max, currCount);
            }
        }

        return max;
    }
}
