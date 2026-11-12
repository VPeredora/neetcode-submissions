class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int[] when = new int[s.length()];
        Arrays.fill(when, removable.length + 1);

        for (int i = 0; i < removable.length; i++)
            when[removable[i]] = i + 1;

        int l = 0, r = removable.length;

        while (l < r) {
            int mid = (l + r + 1) / 2;
            int j = 0;

            for (int i = 0; i < s.length(); i++) 
                if (when[i] > mid && j < p.length() && s.charAt(i) == p.charAt(j)) j++;
            
            if (j == p.length()) l = mid;
            else r = mid - 1;
        }

        return l;
    }
}
