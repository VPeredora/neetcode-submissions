class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int amount = 0, result = 0;

        for (int l = 0, r = 0; r < fruits.length; r++) {
            baskets.merge(fruits[r], 1, Integer::sum);
            amount++;

            while (baskets.size() > 2) {
                int fruit = fruits[l];
                baskets.merge(fruit, -1, Integer::sum);
                amount--;
                if (baskets.get(fruit) == 0) baskets.remove(fruit);
                l++;
            }

            result = Math.max(result, amount);
        }

        return result;
    }
}