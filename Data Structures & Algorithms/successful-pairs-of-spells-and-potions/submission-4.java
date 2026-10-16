class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int l = 0, r = potions.length;

            while (l < r) {
                int mid = l + (r - l) / 2;
                long strength = (long) spells[i] * potions[mid];

                if (strength >= success) r = mid;
                else l = mid + 1;
            }

            result[i] = potions.length - l;
        }

        return result;
    }
}
