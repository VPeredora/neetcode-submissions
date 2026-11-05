class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> pairs = keyStore.getOrDefault(key, new ArrayList<>());
        int l = 0, r = pairs.size() - 1;
        String result = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (pairs.get(mid).getKey() <= timestamp) {
                result = pairs.get(mid).getValue();
                l = mid + 1;
            } else r = mid - 1;
        }

        return result;
    }
}
