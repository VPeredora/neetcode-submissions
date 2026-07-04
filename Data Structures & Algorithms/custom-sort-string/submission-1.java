class Solution { // O(nlogn)
    public String customSortString(String order, String s) {
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++)
            rank[order.charAt(i) - 'a'] = i + 1;
        
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++)
            arr[i] = s.charAt(i);
        
        Arrays.sort(arr, (a, b) -> Integer.compare(rank[a - 'a'], rank[b - 'a']));

        StringBuilder result = new StringBuilder(s.length());
        for (char c : arr)
            result.append(c);
        
        return result.toString();
    }
}
