class Solution {
    public void nextPermutation(int[] nums) {
        /*
         * Problem Statement:
         * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
         * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
         * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
         * The replacement must be in place and use only constant extra memory.
         *
         * Constraints:
         * 1 <= nums.length <= 100
         * 0 <= nums[i] <= 100
         */
        
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        
        // Step 1: Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // Step 2: If the pivot is found, find the element just larger than nums[i] from the right
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap them
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the elements to the right of index i
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}