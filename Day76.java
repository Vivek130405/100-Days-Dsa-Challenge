import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(nums, index, count, 0, n - 1);

        List<Integer> ans = new ArrayList<>();

        for (int x : count) {
            ans.add(x);
        }

        return ans;
    }

    void mergeSort(int[] nums, int[] index, int[] count, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(nums, index, count, left, mid);
        mergeSort(nums, index, count, mid + 1, right);

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int smaller = 0;

        while (i <= mid && j <= right) {

            if (nums[index[j]] < nums[index[i]]) {
                temp[k++] = index[j++];
                smaller++;
            } else {
                count[index[i]] += smaller;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            count[index[i]] += smaller;
            temp[k++] = index[i++];
        }

        while (j <= right) {
            temp[k++] = index[j++];
        }

        for (i = left; i <= right; i++) {
            index[i] = temp[i - left];
        }
    }
}