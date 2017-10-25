package dataContruct;

import java.util.LinkedList;

/**
 * 
 * @author Json
 *
 * @param <E>
 */
public class SortableLinkedList<E extends Comparable<E>> extends LinkedList<E> {
    public void addinOrder(E target) {
        //        Predecessor<E> prev = this;
        //        ListNode<E> node = getNext();
        //        while ((node != null) && (node.getitem().compareTo(target) < 0)) {
        //            prev = node;
        //            node = node.getNext();
        //        }
        //        prev.setNext(new ListNode<E>(target, node));
    }

    /*链表排序*/
    public void insertSort() {
        SortableLinkedList<E> newList = new SortableLinkedList<E>();
        for (E e : this) {
            newList.addinOrder(e);
        }
        //        setNext(newList.getNext());

    }

    public static void main(String[] args) {
        SortableLinkedList<String> slist = new SortableLinkedList<String>();
        slist.add("3");
        slist.add("5");
        slist.add("2");
        slist.insertSort();
        System.out.println(slist);
    }

}
