class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int l = 0;

        for (int r = 0; r < fruits.length; r++) {
            baskets.merge(fruits[r], 1, Integer::sum);

            if (baskets.size() > 2) {
                baskets.merge(fruits[l], -1, Integer::sum);
                if (baskets.get(fruits[l]) == 0) baskets.remove(fruits[l]);
                l++;
            }
        } 

        return fruits.length - l;
    }
}