package _lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    class Node{
        Integer key;
        Integer value;
        Node prev;
        Node next;
        
        public Node(Integer key, Integer value, Node prev, Node next){
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node head;
    
    private Node tail;
    
    private Map<Integer, Node> keyNode;
    
    private int capacity;
    
    public int getCapacity(){
        return capacity;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    public LRUCache(int capacity) {
        setCapacity(capacity);
        head = null;
        tail = null;
        keyNode = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            moveToTail(node);
            return keyNode.get(key).value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        // A key already in the cache
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            moveToTail(node);
            node.value = value;
            return;
        }
        
        // A new key when cache with full capacity. Evict.
        if(getCapacity() <= keyNode.size()){
            keyNode.remove(head.key);
            removeNode(head);
        }
        
        // Add new key value pair into list and map.
        Node newTail = new Node(key, value, tail, null);
        keyNode.put(key, newTail);
        addNode(newTail);
        return;
        
    }
    
    private void removeNode(Node node){
        
        if(node == null){
            return;
        }
        
        if(node == head){
            head = node.next;
            if(head != null){
                head.prev = null;
            }
            return;
        }
        
        if(node == tail){
            tail = node.prev;
            if(tail != null){
                tail.next = null;
            }
            return;
        }
        
        node.next.prev = node.prev;
        node.prev.next = node.next;
        
    }
    
    private void addNode(Node node){
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    
    private void moveToTail(Node node){
        removeNode(node);
        addNode(node);
    }
}