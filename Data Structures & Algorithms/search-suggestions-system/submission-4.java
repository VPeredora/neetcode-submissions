class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        Arrays.sort(products);
        int start = 0, N = products.length;

        for (char c : searchWord.toCharArray()) {
            String prefixStr = prefix.append(c).toString();

            int idx = Arrays.binarySearch(products, start, N, prefixStr);
            start = idx >= 0 ? idx : -(idx + 1);

            List<String> suggest = new ArrayList<>();

            for (int i = start; i < Math.min(N, start + 3); i++)
                if (products[i].startsWith(prefixStr))  
                    suggest.add(products[i]);
                else break;

            result.add(suggest);
        }

        return result;
    }
}
