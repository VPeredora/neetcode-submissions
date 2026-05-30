class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] prefix = new int[N];
        prefix[0] = 1;
        int multiPref = prefix[1] = nums[0];
        for (int i = 2; i < N; i++) {
            multiPref *= nums[i - 1];
            prefix[i] = multiPref;
        }
        System.out.println(Arrays.toString(prefix));

        int[] suffix = new int[N];
        suffix[N - 1] = 1;
        int multiSuff = suffix[N - 2] = nums[N - 1];
        for (int i = N - 3; i >= 0; i--) {
            multiSuff *= nums[i + 1];
            suffix[i] = multiSuff;
        }
        System.out.println(Arrays.toString(suffix));

        int[] result = new int[N];
        for (int i = 0; i < N; i++)
            result[i] = prefix[i] * suffix[i];
        return result;
    }
}  
