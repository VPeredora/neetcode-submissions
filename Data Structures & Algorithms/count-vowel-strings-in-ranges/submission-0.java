class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] vowelStrings = new boolean[words.length];
        for (int i = 0; i < words.length; i++)
            if (words[i].matches("[aeiou](\\w*[aeiou])?")) 
                vowelStrings[i] = true;
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            for (; li <= ri; li++)
                if (vowelStrings[li]) 
                    answer[i]++;
        }

        return answer;
    }
}