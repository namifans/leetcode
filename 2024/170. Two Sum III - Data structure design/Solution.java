class TwoSum {

    HashMap<Integer, Integer> map;
    List<Integer> list;

    public TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<Integer>();
    }
    
    public void add(int number) {
        list.add(number);
        map.put(number, list.size() - 1);
    }
    
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int key = value - list.get(i);
            if (map.containsKey(key) 
                && map.get(key) != i)
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */