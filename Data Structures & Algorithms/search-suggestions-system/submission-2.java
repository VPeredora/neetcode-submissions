class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, (a, b) -> { return a.compareTo(b); });
        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char c : searchWord.toCharArray()) {
            String search = prefix.append(c).toString();
            int l = 0, r = products.length;
            
            while (l < r) {
                int mid = l + (r - l) / 2;

                if (products[mid].compareTo(search) < 0) l = mid + 1;
                else if (products[mid].compareTo(search) >= 0) r = mid;
            }

            List<String> suggest = new ArrayList<>();
        
            while (l < products.length && suggest.size() < 3 && 
                products[l].startsWith(search))
                suggest.add(products[l++]);
            
            result.add(suggest);
        }

        return result;
    }
}
