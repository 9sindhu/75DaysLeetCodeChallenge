class Solution {
    public int search(int[] nums, int target) {

         int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // If target found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[l] <= nums[mid]) {

                // Target lies in left half
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else { // Right half is sorted

                // Target lies in right half
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1; // Not found



    }
}