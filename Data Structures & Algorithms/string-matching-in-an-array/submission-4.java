class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> substrings = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        for (int i = 0; i < words.length - 1; i++)
            for (int j = i + 1; j < words.length; j++)
                if (rabinKarp(words[i], words[j]) >= 0) {
                    substrings.add(words[i]);
                    break;
                }
            
        return substrings;
    }

    private int rabinKarp(String substring, String word) {
        int base1 = 31, base2 = 37;
        int mod = (int) Math.pow(10, 9) + 7;
        long power1 = 1, power2 = 1;

        for (int k = 0; k < substring.length(); k++) {
            power1 = (power1 * base1) % mod;
            power2 = (power2 * base2) % mod;
        }

        long substringHash1 = 0, substringHash2 = 0;
        long wordHash1 = 0, wordHash2 = 0;

        for (int i = 0; i < substring.length(); i++) {
            substringHash1 = (substringHash1 * base1 + substring.charAt(i)) % mod;
            substringHash2 = (substringHash2 * base2 + substring.charAt(i)) % mod;
            wordHash1 = (wordHash1 * base1 + word.charAt(i)) % mod;
            wordHash2 = (wordHash2 * base2 + word.charAt(i)) % mod;
        }

        for (int i = 0; i <= word.length() - substring.length(); i++) {
            if (substringHash1 == wordHash1 && substringHash2 == wordHash2) return i;

            if (i + substring.length() < word.length()) {
                wordHash1 = (wordHash1 * base1 - word.charAt(i) * power1 + word.charAt(i + substring.length())) % mod;
                wordHash2 = (wordHash2 * base2 - word.charAt(i) * power2 + word.charAt(i + substring.length())) % mod;
            }

            if (wordHash1 < 0) wordHash1 += mod;
            if (wordHash2 < 0) wordHash2 += mod;
        }

        return -1;
    }
}