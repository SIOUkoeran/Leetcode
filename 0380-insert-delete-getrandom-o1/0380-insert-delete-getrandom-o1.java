class RandomizedSet {
    private final Set<Integer> set;
    private final Random random;
    public RandomizedSet() {
        random = new Random();
        this.set = new HashSet<Integer>();   
    }
    
    public boolean insert(int val) {
        if (set.contains(val))
            return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val))
            return false;
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx = 0;
        int getIdx = random.nextInt(set.size());
        int returnValue = 0;
        for (int value : set) {
            if (idx == getIdx) {
                returnValue = value;
            }
            ++idx;
        }
        return returnValue;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */