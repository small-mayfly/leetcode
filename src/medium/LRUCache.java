package medium;

import java.util.HashMap;

public class LRUCache {
	// �������ݽṹ���ڴ洢��������
	class CacheNode{
		int key;
		int val;
		// �γ��������ڴ���
		CacheNode pre;
		CacheNode next;
	}
	// ��¼�����ͷβ
	private CacheNode head, tail;
	// ���ڼ�¼��ǰ���нڵ�
	private HashMap<Integer, CacheNode> rem;
	// �����ڴ�����
	private int capacity;
	// ���õ�ǰ��С
	public int size;
	// ��ĳ���ڵ��ƶ���ĩβ��
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
	// ����һ���ڵ��Ƴ�
	private int removeFirst() {
		CacheNode t = this.head.next;
		
		this.head.next = t.next;
		t.next.pre = this.head;
		this.size--;
		this.rem.remove(t.key);
//		this.rem.remove(key)
		return t.val;
	}
	// ��ʼ���ڴ�ռ�
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
    // ��key��ȡ�ڴ��е�ֵ
    public int get(int key) {
        if(rem.containsKey(key)) {
        	moveToEnd(rem.get(key));
        	return rem.get(key).val;
        }else {
        	return -1;
        }
    }
    // ��ĳ��kv���ݷ����ڴ�
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
