class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        List<String> group = new ArrayList<>();
        Set<String> usedStrings = new HashSet<>(strs.length);
        int[] count = new int[26];
        Arrays.fill(count, 0);

        for (int i = 0; i < strs.length; i++) {
            if (usedStrings.contains(strs[i])) continue;
            group.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].length() == strs[j].length()) {
                    for (int k = 0; k < strs[i].length(); k++) {
                        count[strs[i].charAt(k) - 'a']++;
                        count[strs[j].charAt(k) - 'a']--;
                    }
                
                    if (isAnnagram(count)) {
                        group.add(strs[j]);
                        usedStrings.add(strs[j]);
                    } else Arrays.fill(count, 0);
                }
            }

            anagrams.add(new ArrayList<>(group));
            group.clear();
        }

        return anagrams;
    }

    private boolean isAnnagram(int[] count) {
        for (int i : count)
            if (i != 0) return false;
        return true;
    }
}