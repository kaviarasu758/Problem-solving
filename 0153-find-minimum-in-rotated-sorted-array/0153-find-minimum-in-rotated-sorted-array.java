class Solution {
    public int findMin(int[] nums) {
        int length = nums.length; 
        if (nums[0] <= nums[length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}