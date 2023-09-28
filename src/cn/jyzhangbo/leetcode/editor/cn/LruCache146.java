/**

 请你设计并实现一个满足 
 LRU (最近最少使用) 缓存 约束的数据结构。
 

 
 实现 
 LRUCache 类：
 

 
 
 
 LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-
value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
 
 
 

 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 

 

 示例： 

 
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 

 

 提示： 

 
 1 <= capacity <= 3000 
 0 <= key <= 10000 
 0 <= value <= 10⁵ 
 最多调用 2 * 10⁵ 次 get 和 put 
 

 Related Topics 设计 哈希表 链表 双向链表 👍 2950 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LruCache146{
   
    public static void main(String[] args) {
        LRUCache solution = new LruCache146().new LRUCache(2);
        solution.put(1,1);
        solution.put(2,2);
        solution.get(1);
        solution.put(3,3);
        solution.get(2);
        solution.put(4,4);
        solution.get(1);
        solution.put(4,4);
        solution.get(1);
        solution.get(3);
        solution.get(4);
    }
//leetcode submit region begin(Prohibit modification and deletion)
    class DLinkNode {
        public int key;
        public int val;
    public DLinkNode pre;
    public DLinkNode next;

    public DLinkNode(){}
    public DLinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
        private Map<Integer, DLinkNode> cache;
        int size;
        int capacity;
    DLinkNode head;
    DLinkNode tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (cache.get(key) == null) {
            return -1;
        } else {
            DLinkNode node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode == null) {
            dLinkNode = new DLinkNode(key, value);
            cache.put(key, dLinkNode);
            size++;
            addToHead(dLinkNode);

            if (size > capacity) {
                DLinkNode dLinkNode1 = removeTail();
                cache.remove(dLinkNode1.key);
                size--;
            }

        } else {
            dLinkNode.val = value;
            moveToHead(dLinkNode);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}