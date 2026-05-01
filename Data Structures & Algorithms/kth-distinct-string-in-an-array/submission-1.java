class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new LinkedHashSet<>();
        Set<String> notDistinct = new HashSet<>();

        for (String str : arr)
            if (notDistinct.contains(str)) continue;
            if (!distinct.add(str)) {
                distinct.remove(str);
                notDistinct.add(str);
            }

        return distinct.stream().skip(k - 1).findFirst().orElse("");
    }
}
