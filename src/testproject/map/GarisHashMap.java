/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject.map;

/**
 *
 * @author internet
 */
public class GarisHashMap<K, V> {

    private int DEFAULT_BUCKET_COUNT = 128;
    private Entry<K, V>[] buckets;

    public GarisHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public V get(K key) {
        throwIfKeyNull(key);

        Entry<K, V> entry = buckets[bucketIndexForKey(key)];
        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        return entry != null ? entry.getValue() : null;
    }

    public void put(K key, V value) {
        throwIfKeyNull(key);

        int bucketIndex = bucketIndexForKey(key);
        Entry<K, V> entry = buckets[bucketIndex];

        if (null != entry) {
            boolean done = false;
            while (!done) {
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                    done = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new Entry<K, V>(key, value));
                    done = true;
                }
                entry = entry.getNext();
            }
        } else {
            //nothing there at all; just shove the new entry in
            buckets[bucketIndex] = new Entry<K, V>(key, value);
        }
    }
    /// should be private, just for test...
    public int bucketIndexForKey(K key) {
        int bucketIndex = key.hashCode() % buckets.length;
        return bucketIndex;
    }

    private void throwIfKeyNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key may not be null");
        }
    }
}
