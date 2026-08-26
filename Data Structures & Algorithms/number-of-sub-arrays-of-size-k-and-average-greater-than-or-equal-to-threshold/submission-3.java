class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold *= k;
        int sum = 0, amount = 0;

        for (int i = 0; i < k - 1; i++)
            sum += arr[i];
        
        for (int i = 0; i <= arr.length - k; i++) {
            sum += arr[i + k - 1];
            if (sum >= threshold) amount++;
            sum -= arr[i];
        }

        return amount;
    }
}