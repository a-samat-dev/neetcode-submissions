public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {
            if (right - left <= k) {
                if (set.contains(nums[right])) {
                    return true;
                }
                set.add(nums[right]);
                right++;
            } else {
                set.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}
