package medium;

import java.util.HashMap;

public class LRUCache {
	// 创建数据结构用于存储所有数据
	class CacheNode{
		int key;
		int val;
		// 形成链表，便于处理
		CacheNode pre;
		CacheNode next;
	}
	// 记录链表的头尾
	private CacheNode head, tail;
	// 用于记录当前所有节点
	private HashMap<Integer, CacheNode> rem;
	// 设置内存容量
	private int capacity;
	// 设置当前大小
	public int size;
	// 将某个节点移动到末尾处
	private void moveToEnd(CacheNode cn) {
		if(cn.next==null)
			return ;
		
		cn.pre.next = cn.next;
		cn.next.pre = cn.pre;
		
		
		cn.next = this.tail;
		cn.pre = this.tail.pre;
		
		cn.pre.next = cn;
		this.tail.pre = cn;

	}
	// 将第一个节点移除
	private int removeFirst() {
		CacheNode t = this.head.next;
		
		this.head.next = t.next;
		t.next.pre = this.head;
		this.size--;
		this.rem.remove(t.key);
//		this.rem.remove(key)
		return t.val;
	}
	// 初始化内存空间
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head = new CacheNode();
		this.tail = new CacheNode();
		this.head.pre = null;
		this.head.next = this.tail;
		this.tail.pre = this.head;
		this.tail.next = null;
		this.rem = new HashMap<Integer, CacheNode>();
		this.size = 0;
    }
    // 按key获取内存中的值
    public int get(int key) {
        if(rem.containsKey(key)) {
        	moveToEnd(rem.get(key));
        	return rem.get(key).val;
        }else {
        	return -1;
        }
    }
    // 将某个kv数据放入内存
    public void put(int key, int value) {
        if(rem.containsKey(key)) {
        	CacheNode t = rem.get(key);
        	t.val = value;
        	moveToEnd(t);
        }else {
        	if(this.size>=this.capacity) {
        		removeFirst();
        	}
        	CacheNode t = new CacheNode();
        	t.key = key;
        	t.val = value;
        	t.next = this.tail;
        	t.pre = this.tail.pre;
        	this.tail.pre.next = t;
        	this.tail.pre = t;
        	this.size++;
        	rem.put(key, t);
        }
    }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
