/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * {@link https://leetcode.com/problems/lru-cache/}
 */

import java.util.*;

class LRUCache {

    private int capacity;
    
    private Map<Integer, Integer> CACHE = new LinkedHashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer data = CACHE.get(key);
        if ( data == null ) {
            data = -1;
        } else {
            put(key, data);
        }
        
        return data;
    
    }
    
    public void put(int key, int value) {
        if (this.CACHE.containsKey(key)) {
            this.CACHE.remove(key);
        } else if(CACHE.size() == this.capacity ) {
            Iterator<Integer> it = this.CACHE.keySet().iterator();
            it.next();
            it.remove();
        }
        
        CACHE.put(key,value);
    }
}

