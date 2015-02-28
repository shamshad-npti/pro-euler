/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;
import projecteuler.AbstractHeap.HeapEntry;
/**
 *
 * @author shame
 */
public interface Heap<K, V> {
    public HeapEntry<K, V> extract();
    public HeapEntry<K, V> peek();
    public void changeKey(int i, K k);
    public void insert(HeapEntry<K, V> elem);  
    public int valueIndex(V value);
}
