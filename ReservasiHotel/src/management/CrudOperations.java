package management;

public interface CrudOperations<T> {
    void create(T item);
    T read(String key);
    void update(String key, T newItem);
    void delete(String key);
}
