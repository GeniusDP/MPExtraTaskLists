import mylist.MyList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyList lst = new MyList();
        lst.add( 1 );
        lst.add( 2 );
        lst.add( 3 );
        lst.add( new MyList(4, List.of(1000, 10001), new MyList(7, 8), 6) );
        lst.add( "Bogdan" );
        System.out.println( lst.cdr().cdr().cdr().car() );
        for(var x: lst){
            System.out.println( x );
        }

    }

}
