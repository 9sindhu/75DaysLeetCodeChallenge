class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost,
            // minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, minimum is in left half (including mid)
            else {
                right = mid;
            }
        }

        // At the end, left == right → pointing to minimum
        return nums[left];
    

    }
}