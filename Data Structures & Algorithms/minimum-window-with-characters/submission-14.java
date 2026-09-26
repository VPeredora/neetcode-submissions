class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) return "";

        Map<Character, Integer> frequency = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray())
            frequency.merge(c, 1, Integer::sum);

        int haveChars = 0, needChars = frequency.size();
        int resLength = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (frequency.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (window.get(c).equals(frequency.get(c))) haveChars++;
            }

            while (haveChars == needChars) {
                if ((r - l + 1) < resLength) {
                    resLength = r - l + 1;
                    result[0] = l; result[1] = r;
                }
                
                char delChar = s.charAt(l);
                if (frequency.containsKey(delChar)) {
                    window.merge(delChar, -1, Integer::sum);
                    if (window.get(delChar) < frequency.get(delChar)) haveChars--;
                }
                l++;
            }
        }

        return resLength == Integer.MAX_VALUE ? "" : 
               s.substring(result[0], result[1] + 1);
    }
}
