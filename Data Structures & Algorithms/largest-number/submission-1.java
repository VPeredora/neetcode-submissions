class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[i];
        
        Arrays.sort(arr, (a, b) -> {
            String num1 = String.valueOf(a);
            String num2 = String.valueOf(b);
            return (num2 + num1).compareTo(num1 + num2);
        });

        if (arr[0] == 0) return "0";

        String[] result = Arrays.stream(arr).map(String::valueOf).toArray(String[]::new);

        return String.join("", result);
    }
}