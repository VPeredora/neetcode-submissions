class TimeMap {
    private Map<String, Map<Integer, List<String>>> keyValue;

    public TimeMap() {
        keyValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (keyValue.containsKey(key)) {
            Map<Integer, List<String>> timeValues = keyValue.get(key);

            if (timeValues.containsKey(timestamp)) timeValues.get(timestamp).add(value);
            else timeValues.put(timestamp, new ArrayList<>(List.of(value)));
        } else {
            Map<Integer, List<String>> timeValues = new HashMap<>();
            List<String> values = new ArrayList<>(List.of(value));

            timeValues.put(timestamp, values);
            keyValue.put(key, timeValues);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!keyValue.containsKey(key)) return "";
        Map<Integer, List<String>> timeValues = keyValue.get(key);
        
        for (int i = timestamp; i >= 0; i--)
            if (timeValues.containsKey(i)) {
                List<String> values = timeValues.get(i);
                return values.get(values.size() - 1);
            }

        return "";
    }
}
