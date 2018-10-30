import java.util.*;
public class RandomQueue<E>{
    private LinkedList<E> queue;

    public RandomQueue(){
        queue = new LinkedList<E>();
    }

    public void add(E e){
        if(Math.random()<0.5)
            queue.addLast(e);
        else
            queue.addFirst(e);
    }

    public E poll(){
        E result=null;
        if(queue.size()!=0){
            if(Math.random()<0.5)
                result = queue.removeLast();
            else
                result = queue.removeFirst();
         }
         return result;
    }

    public int size(){
        return queue.size();
    }
}
