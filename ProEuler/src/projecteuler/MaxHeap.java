package projecteuler;
/**
 *
 * @author shame
 */
public class MaxHeap<K extends Comparable<? super K>, V> extends AbstractHeap<K, V> {
    
    public MaxHeap(int size) {
        super(size);
    }
    
    @Override
    protected boolean compare(K parent, K child) {
        return parent.compareTo(child) < 0;
    }
}
