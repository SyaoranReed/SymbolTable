
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel
 */
public class OrderedLinkedList<T extends Comparable<T>> implements Iterable<T>
{

    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public OrderedLinkedList()
    {
    }

    @Override
    public Iterator<T> iterator()
    {
        return new IteratorCustomList();
    }

    private class Nodo<T>
    {

        private T item;
        private Nodo<T> next;
        private Nodo<T> before;
    }

    private class IteratorCustomList<T> implements Iterator<T>
    {

        private Nodo<T> current;
        private Nodo<T> lastCurrent;

        public IteratorCustomList()
        {
            this.current = (Nodo<T>) head;
        }

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            Nodo<T> anterior = lastCurrent.before;
            Nodo<T> siguiente = lastCurrent.next;
            anterior.next = siguiente;
            size--;
        }

        @Override
        public T next()
        {
            this.lastCurrent = this.current;
            this.current = (Nodo<T>) current.next;
            return this.lastCurrent.item;
        }
    }

    public void add(T item)
    {
        size++;
        if(this.head == null){
            this.head = new Nodo<T>();
            this.head.item = item;
            this.tail = head;
            return;
        }
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.item = item;
        nuevo.before = this.tail;
        this.tail.next = nuevo;
        this.tail = nuevo;
        sortLastItem();
    }

    public void remove(T item)
    {
        Iterator<T> it = iterator();
        while(it.hasNext()){
            if(it.next() == item){
                it.remove();
                break;
            }
        }
    }

    public void remove(int index)
    {
        Iterator<T> it = iterator();
        int i = 0;
        while(it.hasNext()){
            it.next();
            if(i == index){
                it.remove();
                break;
            }
            i++;
        }
    }

    private void sortLastItem()
    {
        Nodo<T> current = this.tail;
        Nodo<T> before;
        T aux;
        while(current != null){
            before = current.before;
            while(before != null){
                if(current.item.compareTo(before.item) < 0){
                    aux = current.item;
                    current.item = before.item;
                    before.item = aux;
                    current = before;
                    break;
                }
                else{
                    return;
                }
            }
            if (before == null){
                return;
            }
        }
    }

    public T get(int index)
    {
        Iterator<T> it = iterator();
        int i = 0;
        while(it.hasNext()){
            if(i == index){
                return it.next();
            }
            it.next();
            i++;
        }
        return null;
    }
    
    public int size()
    {
        return size;
    }
}
