class MyHashMap {
    private ListNode[] map;

    private static class ListNode {
        int key, value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        ListNode() {
            this(-1, -1); // constructor chaining
        }
    }

    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < map.length; i++)
            map[i] = new ListNode();
    }
    
    public void put(int key, int value) {
        ListNode bucket = map[key % map.length];

        while (bucket.next != null) {
            if (bucket.next.key == key) {
                bucket.next.value = value;
                return;
            }
            bucket = bucket.next;
        }

        bucket.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        ListNode bucket = map[key % map.length].next;

        while (bucket != null) {
            if (bucket.key == key) return bucket.value;
            bucket = bucket.next;
        }

        return -1;
    }

    public void remove(int key) {
        ListNode bucket = map[key % map.length];

        while (bucket.next != null) {
            if (bucket.next.key == key) {
                bucket.next = bucket.next.next;
                return;
            }
            bucket = bucket.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */