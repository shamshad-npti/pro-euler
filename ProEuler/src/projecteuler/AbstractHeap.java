package projecteuler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shame
 * @param <K>
 * @param <V>
 */
public abstract class AbstractHeap<K extends Comparable<? super K>, V> 
        implements Heap<K, V> {
    private int pos;
    private final HeapEntry<K, V>[] elem;
    private final Map<V, Integer> indx;

    public AbstractHeap(int size) {
        elem = new HeapEntry[size];
        indx = new HashMap<>();
    }
        
    @Override
    public HeapEntry<K, V> peek() {
        return elem[0];
    }
    
    void out() {
        for (int i = 0; i < pos; i++) {
            System.out.print(elem[i].key + " ");
        }
        System.out.println("");
    }

    @Override
    public int valueIndex(V value) {
        return indx.getOrDefault(value, -1);
    }
    
    @Override
    public HeapEntry<K, V> extract() {
        HeapEntry<K, V> max = elem[0];
        indx.remove(max.value);
        elem[0] = elem[pos - 1];
        indx.put(elem[0].value, 0);
        pos--;
        heapify(0);
        return max;
    }
    
    @Override
    public void changeKey(int index, K value) {
        K k = elem[index].key;
        elem[index].key = value;
        if(k.compareTo(value) < 0)
            fixUp(index);
        else
            heapify(index);
    }
    
    @Override
    public void insert(HeapEntry<K, V> e) {
        pos++;
        elem[pos - 1] = e;
        fixUp(pos - 1);
    }
    
    public boolean isEmpty() {
        return pos == 0;
    }
    
    private void fixUp(int i) {
        int p = parent(i);
        while(i > 0 && compare(elem[p].key, elem[i].key)) {
            exchange(i, p);
            i = p;
            p = parent(i);
        }
    }
    
    protected int left(int i) { return (i << 1) + 1; }
    protected int right(int i) { return (i << 1) + 2; }
    protected int parent(int i) { return ((i - 1) >> 1); }
    
    protected abstract boolean compare(K parent, K child);
    
    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int max = i;
        if(left < pos && compare(elem[max].key, elem[left].key)) 
            max = left;
        if(right < pos && compare(elem[max].key, elem[right].key))
            max = right;
        if(max != i) {
            exchange(max, i);
            heapify(max);
        }
    }
    
    protected void exchange(int i, int j) {
        elem[j].index = i;
        elem[i].index = j;
        indx.put(elem[j].value, i);
        indx.put(elem[i].value, j);
        HeapEntry<K, V> e = elem[i];
        elem[i] = elem[j];
        elem[j] = e;
    }    

    public int size() {
        return pos + 1;
    }

    public static class HeapEntry<Key, Value> {
        int index;
        Key key;
        private Value value;
        
        public HeapEntry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
        
        public int getIndex() {
            return index;
        }

        public Key getKey() {
            return key;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public Value getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + "," + value + ", " + index + "]"; //To change body of generated methods, choose Tools | Templates.
        }        
    }
}
