package mylist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/**
 * Lombok, hello!)
 * */
@Setter
@Getter
@AllArgsConstructor
public class Node {
    @Setter(AccessLevel.PACKAGE)
    private Object value;
    @Setter(AccessLevel.PACKAGE)
    private Node next;

    public Node(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
