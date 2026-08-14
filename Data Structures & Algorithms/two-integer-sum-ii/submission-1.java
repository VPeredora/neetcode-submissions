class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> checked = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = target - numbers[i];

            if (checked.containsKey(number)) 
                return new int[] {checked.get(number) + 1, i + 1};
            checked.put(numbers[i], i);
        }

        return new int[0];
    }
}
