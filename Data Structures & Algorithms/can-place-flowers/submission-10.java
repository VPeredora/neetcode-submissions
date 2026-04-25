class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pot = 0;

        while (pot < flowerbed.length && n > 0) {
            if (flowerbed.length == 1) return flowerbed[0] == 0 ? (n - 1) == 0 : n == 0;
            if (pot == flowerbed.length - 1) return flowerbed[pot] == 0 && flowerbed[pot - 1] == 0 ? (n - 1) == 0 : n == 0; 
            if (flowerbed[pot] == 0 && flowerbed[pot + 1] == 0) n--;
            pot += 2;
        }

        return n == 0;
    }
}