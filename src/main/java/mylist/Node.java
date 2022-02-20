package mylist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/**
 * Lombok, hello!)
 * */
@Setter(AccessLevel.PACKAGE)
@Getter
@AllArgsConstructor
public class Node {
    private Object value;
    private Node next;

    public Node(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
