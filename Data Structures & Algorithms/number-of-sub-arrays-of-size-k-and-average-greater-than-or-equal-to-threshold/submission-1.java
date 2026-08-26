class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold *= k;
        int[] prefix = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++)
            prefix[i + 1] = arr[i] + prefix[i];

        int amount = 0, l = 0;
        for (int r = k - 1; r < arr.length; r++) {
            int sum = prefix[r + 1] - prefix[l++];
            if (sum >= threshold) amount++;
        }

        return amount;
    }
}