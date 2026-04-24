class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charInS = Character.toLowerCase(s.charAt(i));
            char charInT = Character.toLowerCase(t.charAt(i));

            if (charMapping.containsKey(charInS) && charMapping.get(charInS) != charInT) return false;
            if (charMapping.containsValue(charInT) && !charMapping.containsKey(charInS)) return false;
            charMapping.put(charInS, charInT);
        }
            
        return true;
    }
}