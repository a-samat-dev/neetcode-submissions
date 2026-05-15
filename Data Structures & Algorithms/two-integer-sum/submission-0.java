public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> charIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int rem = target - num1;

            if (charIndices.containsKey(rem)) {
                return new int[]{charIndices.get(rem), i};
            }

            charIndices.put(nums[i], i);
        }

        return null;
    }
}