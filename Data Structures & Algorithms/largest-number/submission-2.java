class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);

        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        String result = String.join("", arr);

        return result.charAt(0) == '0' ? "0" : result;
        }
}