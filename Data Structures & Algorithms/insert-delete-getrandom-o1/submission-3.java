class RandomizedSet {
    private Map<Integer, Integer> valueIndex;
    private List<Integer> randomValue;
    private Random random;

    public RandomizedSet() {
        valueIndex = new HashMap<>();
        randomValue = new ArrayList<>();
        random = new Random(31);
    }
    
    public boolean insert(int val) {
        if (valueIndex.containsKey(val)) return false;

        valueIndex.put(val, randomValue.size());
        randomValue.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if (!valueIndex.containsKey(val)) return false;

        Integer index = valueIndex.remove(val);
        Integer value = randomValue.remove(randomValue.size() - 1);
        
        if (index != randomValue.size()) {
            randomValue.set(index, value);
            valueIndex.replace(value, index);
        }
        
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(randomValue.size());
        return randomValue.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */