class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new LinkedHashSet<>();
        Set<String> notDistinct = new HashSet<>();

        for (String str : arr)
            if (!distinct.add(str) || notDistinct.contains(str)) {
                distinct.remove(str);
                notDistinct.add(str);
            }

        return distinct.stream().skip(k - 1).findFirst().orElse("");
    }
}