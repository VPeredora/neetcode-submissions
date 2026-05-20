class MyHashSet {

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private final ListNode[] set;

    public MyHashSet() {
        set = new ListNode[10000];
        for (int i = 0; i < set.length; i++)
            set[i] = new ListNode(0);
    }
    
    public void add(int key) {
        ListNode bucket = set[key % set.length];
        while (bucket.next != null) {
            if (bucket.next.key == key) return;
            bucket = bucket.next;
        }
        bucket.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode bucket = set[key % set.length];
        while (bucket.next != null) {
            if (bucket.next.key == key) {
                bucket.next = bucket.next.next;
                return;
            } 
            bucket = bucket.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode bucket = set[key % set.length];
        while (bucket.next != null) {
            if (bucket.next.key == key) return true;
            bucket = bucket.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */