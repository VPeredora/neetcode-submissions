class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Pair[] pairs = new Pair[names.length];
        for (int i = 0; i < names.length; i++)
            pairs[i] = new Pair(heights[i], names[i]);
        
        Arrays.sort(pairs, (a, b) -> Integer.compare(b.height, a.height));

        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++)
            result[i] = pairs[i].name;
        
        return result;
    }

    static class Pair {
        int height;
        String name;

        Pair (int height, String name) {
            this.height = height;
            this.name = name;
        }
    }
}