class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            if (isSubsequence(s, p, removable, mid)) l = mid;
            else r = mid - 1;
        }

        return l;
    }

    boolean isSubsequence(String s, String p, int[] removable, int mid) {
        Set<Integer> removedIdx = new HashSet<>();
        int p1 = 0, p2 = 0;

        for (int i = 0; i < mid; i++)
            removedIdx.add(removable[i]);

        while (p1 < s.length() && p2 < p.length()) {
            if (!removedIdx.contains(p1) && s.charAt(p1) == p.charAt(p2)) p2++;
            p1++;
        }

        return p2 == p.length();
    }
}
