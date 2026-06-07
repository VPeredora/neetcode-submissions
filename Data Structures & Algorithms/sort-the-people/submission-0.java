class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> sorted = new TreeMap<>();
        for (int i = 0; i < names.length; i++)
            sorted.put(heights[i], names[i]);
        
        String[] result = new String[names.length];
        int pointer = names.length - 1;
        for (Map.Entry<Integer, String> entry : sorted.entrySet())
            result[pointer--] = entry.getValue();
        
        return result;
    }
}