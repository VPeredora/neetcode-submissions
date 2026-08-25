class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        int result = (sum / k) >= threshold ? 1 : 0;
        int l = 0, r = k;

        while (r < arr.length) {
            sum = sum - arr[l++] + arr[r++];
            if ((sum / k) >= threshold) result++;
        }

        return result;
    }
}