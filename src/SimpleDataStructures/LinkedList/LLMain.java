package SimpleDataStructures.LinkedList;

/**
 * Created by Anuradha Sanjeewa on 30/12/2015.
 */
public class LLMain {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(6);

        for(Integer i:ll){
            System.out.println(i);
        }
        System.out.println("popped "+ll.pop());
        System.out.println("popped "+ll.pop());

        for(Integer i:ll){
            System.out.println(i);
        }
    }
}
