class RandomizedSet {
    private Map<Integer, Integer> indexSet;
    private List<Integer> randomizedList;
    private Random random;
    private int index;

    public RandomizedSet() {
        indexSet = new HashMap<>();
        randomizedList = new ArrayList<>();
        random = new Random(31);
        index = 0;
    }
    
    public boolean insert(int val) {
        Integer value = indexSet.putIfAbsent(val, index);
        if (value != null) return false;

        randomizedList.add(val);
        index++;
        System.out.println(index);

        return true;
    }
    
    public boolean remove(int val) {
        Integer valIndex = indexSet.remove(val);
        if (valIndex == null) return false;

        int lastElement = randomizedList.remove(--index);
        if (valIndex != index) {
            randomizedList.set(valIndex, lastElement);
            indexSet.replace(lastElement, valIndex);
        }
        
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(index);
        return randomizedList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */