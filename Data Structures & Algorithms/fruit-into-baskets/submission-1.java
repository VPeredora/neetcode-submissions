class Solution {
    public int totalFruit(int[] fruits) {
        int amount = 0;
        Map<Integer, Integer> baskets = new HashMap<>();

        for (int l = 0, r = 0; r < fruits.length; r++) {
            baskets.put(fruits[r], r);

            if (baskets.size() > 2) {
                l = baskets.get(fruits[r - 1]);
                while (fruits[l] == fruits[l - 1]) l--;
                baskets.remove(fruits[l - 1]);
            }

            amount = Math.max(amount, r - l + 1);
        }

        return amount;
    }  
}