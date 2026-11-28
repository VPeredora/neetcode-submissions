class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        int l = 0, r = products.length - 1;

        Arrays.sort(products);

        for (char c : searchWord.toCharArray()) {
            String prefixStr = prefix.append(c).toString();
            List<String> suggest = new ArrayList<>();
            
            while (l <= r && !products[l].startsWith(prefixStr)) l++;
            while (r >= l && !products[r].startsWith(prefixStr)) r--;

            for (int i = 0; i < Math.min(3, r - l + 1); i++)
                suggest.add(products[i + l]);
            
            result.add(suggest);
        }

        return result;
    }
}
