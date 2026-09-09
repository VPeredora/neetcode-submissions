class Solution {
    public int totalFruit(int[] fruits) {
        int fruit1 = fruits[0], fruit2 = -1;
        int l = 0, fruit1_lastIdx = 0, fruit2_lastIdx = -1;
        int total = 1, result = 1;

        for (int r = 0; r < fruits.length; r++) {
            int fruit = fruits[r];

            if (fruit == fruit1) {
                total++;
                fruit1_lastIdx = r;
            } else if (fruit == fruit2 || fruit2 == - 1) {
                total++;
                fruit2 = fruit;
                fruit2_lastIdx = r;
            } else {
                if (fruit2_lastIdx < fruit1_lastIdx) {
                    int tempIdx = fruit1_lastIdx;
                    fruit1_lastIdx = fruit2_lastIdx;
                    fruit2_lastIdx = tempIdx;
                    
                    int tempFruit = fruit1;
                    fruit1 = fruit2;
                    fruit2 = tempFruit;
                }
                total -= (fruit1_lastIdx - l + 1);
                l = fruit1_lastIdx + 1;
                fruit1 = fruit;
                fruit1_lastIdx = r;
            }
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}