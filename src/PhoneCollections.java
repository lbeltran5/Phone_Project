public interface PhoneCollections <T> {
    boolean add(T item);
    boolean remove(T item);
    boolean contains (T item);
    int size();
    void clear();
    boolean isEmpty();
    String[] toArray();
}
