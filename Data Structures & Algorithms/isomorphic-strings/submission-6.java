class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMappingS = new HashMap<>();
        Map<Character, Character> charMappingT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (charMappingS.containsKey(charS) && charMappingS.get(charS) != charT) return false;
            if (charMappingT.containsKey(charT) && charMappingT.get(charT) != charS) return false;
            
            charMappingS.put(charS, charT);
            charMappingT.put(charT, charS);
        }
            
        return true;
    }
}