package mylist;

public interface List {

    Object get(int index);

    void add(Object object);

    void add(int index, Object newObject);

    boolean isEmpty();

    void remove(int index);

    void set(int index, Object newObject);

    MyList cdr();

    MyList car();

}
