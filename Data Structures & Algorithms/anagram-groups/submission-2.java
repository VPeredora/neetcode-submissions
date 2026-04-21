class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray())
                count[c - 'a']++;

            String frequency = Arrays.toString(count);
            anagrams.putIfAbsent(frequency, new ArrayList<>());
            anagrams.get(frequency).add(s);
        }
        
        return new ArrayList<>(anagrams.values());
    }
}