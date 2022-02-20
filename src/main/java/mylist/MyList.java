package mylist;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Iterator;

@NoArgsConstructor
public class MyList implements List, Iterable<Node>{
    @Getter
    private int length;
    private Node head;

    public MyList(Object ...values) {
        for(var value: values){
           this.add( value );
        }
        length = values.length;
    }

    @SneakyThrows
    @Override
    public MyList car(){
        if( isEmpty() )throw new ImpossibleAccessException("list is empty");
        if( head.getValue() instanceof MyList){
            return (MyList)head.getValue();
        }else{
            return new MyList( head );
        }
    }

    @SneakyThrows
    @Override
    public MyList cdr(){
        if( isEmpty() )throw new ImpossibleAccessException("list is empty");
        MyList myCdrList = new MyList();
        Node currentNode = head.getNext();
        while( currentNode != null ){
            myCdrList.add(currentNode);
            currentNode = currentNode.getNext();
        }
        return myCdrList;
    }

    @SneakyThrows
    @Override
    public Object get(int index) {
        if( index >= length )throw new ImpossibleAccessException("list is empty");
        Node searchedNode = head;
        while( index > 0 ){
            searchedNode = searchedNode.getNext();
            index--;
        }
        return searchedNode;
    }

    @Override
    public void add(Object object) {
        if( head == null ){
            head = new Node( object );
        }
        else{
            Node currentNode = head;
            while(  currentNode.getNext() != null ){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext( new Node( object ) );
        }
        length++;
    }


    @SneakyThrows
    @Override
    public void add(int index, Object newObject) {
        if( index >= length )throw new ImpossibleAccessException("list is empty");
        if(index == 0){
            Node newNode = new Node( newObject, head );
            head = newNode;
        }else{
            Node beforeInsertedNode = head;
            while( index > 1 ){
                beforeInsertedNode = beforeInsertedNode.getNext();
                index--;
            }
            Node newNode = new Node( newObject, beforeInsertedNode.getNext() );
            beforeInsertedNode.setNext( newNode );
        }
        length++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @SneakyThrows
    @Override
    public void remove(int index) {
        if( index >= length )throw new ImpossibleAccessException("list is empty");

        Node beforeDeletedNode = head;
        while( index > 1 ){
            beforeDeletedNode = beforeDeletedNode.getNext();
            index--;
        }
        Node nextAfterDeletedNode = beforeDeletedNode.getNext().getNext();
        beforeDeletedNode.setNext( nextAfterDeletedNode );
        length--;
    }

    @SneakyThrows
    @Override
    public void set(int index, Object newObject) {
        if( index >= length )throw new ImpossibleAccessException("list is empty");

        Node beforeEmplacedNode = head;
        while( index > 1 ){
            beforeEmplacedNode = beforeEmplacedNode.getNext();
            index--;
        }
        Node nextAfterEmplacedNode = beforeEmplacedNode.getNext().getNext();
        Node newNode = new Node( newObject );
        beforeEmplacedNode.setNext( newNode );
        newNode.setNext( nextAfterEmplacedNode );
    }

    @Override
    public String toString() {
        String resultString = "";
        Node currentNode = head;

        if(head == null) return "[]";

        while (currentNode.getNext() != null) {
            resultString += currentNode + ", ";
            currentNode = currentNode.getNext();
        }
        resultString += currentNode;
        return "[" + resultString + "]";
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator();
    }


    private class NodeIterator implements Iterator<Node>{
        private Node currentNode;
        @Override
        public boolean hasNext() {
            if(currentNode == null){
                currentNode = head;
                return currentNode != null;
            }else{
                currentNode = currentNode.getNext();
                return currentNode != null;
            }
        }

        @Override
        public Node next() {
            return currentNode;
        }
    }

}
