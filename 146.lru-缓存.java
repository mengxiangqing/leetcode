import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
/*
 * 思路：使用Map和双向链表来实现，因为是双向链表可以在o1时间复杂度内实现
 * 节点的取出、删除指定节点、添加在指定位置
 */
class LRUCache {
    // 双向链表
    class DLinkedList {

        private int key;
        private int value;
        private DLinkedList pre;
        private DLinkedList next;

        public DLinkedList() {

        }

        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    // 当前有效元素个数
    private int size;
    private DLinkedList head, tail;
    private Map<Integer, DLinkedList> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
        this.cache = new HashMap<>();
        size = 0;

    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkedList node = cache.get(key);
            moveToHead(node);
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            node = new DLinkedList(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                DLinkedList old = delTail();
                cache.remove(old.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    public void addToHead(DLinkedList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void moveToHead(DLinkedList node) {
        delNode(node);
       addToHead(node);
    }


    // 在双向链表中删除节点
    public void delNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 删除双向链表中的尾巴节点
    public DLinkedList delTail() {
        DLinkedList temp = tail.pre;
        delNode(temp);
        return temp;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
