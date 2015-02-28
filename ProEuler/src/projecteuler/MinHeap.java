package projecteuler;
/**
 *
 * @author shame
 */
public class MinHeap<K extends Comparable<? super K>, V> extends AbstractHeap<K, V> {

    public MinHeap(int size) {
        super(size);
    }

    @Override
    protected boolean compare(K parent, K child) {
        return parent.compareTo(child) > 0;
    }
    
}
