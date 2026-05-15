public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = 0;
        int res = 0;
        int currSum = 0;

        while (right < arr.length) {
            if (right - left < k) {
                currSum += arr[right];
                right++;

                if (right - left == k) {
                    int avr = currSum / k;

                    if (avr >= threshold) {
                        res++;
                    }
                }
            } else {
                currSum -= arr[left];
                left++;
            }
        }

        return res;
    }
}
