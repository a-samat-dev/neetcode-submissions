public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int currSum = 0;

        while (right < nums.length) {
            currSum += nums[right];
            right++;

            while (currSum >= target) {
                res = Math.min(right - left, res);
                currSum -= nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
