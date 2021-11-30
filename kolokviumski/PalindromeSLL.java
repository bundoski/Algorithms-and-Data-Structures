/*
package kolokviumski;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(){
        this.element = null;
        this.succ = null;
    }

    public SLLNode(E elem){
        this.element = elem;
        this.succ = null;
    }

    public SLLNode(E elem,  SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
class SLL<E extends Comparable> {
    private  SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public SLL( SLLNode<E> first){
        this.first = first;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
             SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
             SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
         SLLNode<E> ins = new  SLLNode<E>(o, first);  //
        first = ins;
    }

    public void insertAfter(E o,  SLLNode<E> node) {
        if (node != null) {
             SLLNode<E> ins = new  SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o,  SLLNode<E> before) {

        if (first != null) {
             SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                 SLLNode<E> ins = new  SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
             SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
             SLLNode<E> ins = new  SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
             SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete( SLLNode<E> node) {
        if (first != null) {
             SLLNode<E> tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public  SLLNode<E> getFirst() {
        return first;
    }

    public  SLLNode<E> find(E o) {
        if (first != null) {
             SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

*/
/*   public Iterator<E> iterator () {
        // Return an iterator that visits all elements of this list, in left-to-right order.
        return new  SLL.LRIterator<E>();
    }*//*


    // //////////Inner class ////////////


    public void mirror(){
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
             SLLNode<E> tmp = first;
             SLLNode<E> newsucc = null;
             SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }

    }

    public void merge ( SLL<E> in){
        if (first != null) {
             SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }


    public void removeDuplicatesSorted( SLL<E> orig){
         SLLNode<E> curr = orig.first;
         SLLNode<E> tmp = curr;
        if(curr == null)
            return ;

        while(curr != null) {
            while(tmp != null && tmp.element==curr.element){
                tmp = tmp.succ;
                curr.succ = tmp;
            }
            curr = curr.succ;
            tmp = curr;
        }
    }

    public void removeDuplicatesUnsorted(){

         SLLNode<E> tmp1 = null, tmp2 = null;
        tmp1 = first;

        while(tmp1 != null && tmp1.succ != null){
            tmp2 = tmp1;
            while(tmp2.succ != null){
                if(tmp1.element == tmp2.succ.element){

                    tmp2.succ = tmp2.succ.succ;
                }
                else
                    tmp2=tmp2.succ;
            }
            tmp1=tmp1.succ;
        }
    }



    // ZADACA 3
    // Spoi dve ednostrano povrzani listi taka sho rezultantnata ce bidi sortirana vo rastecki redosled

    public  SLL<E> join( SLL<E> list1,  SLL<E> list2) {

        SLL<E> rezultantna = new SLL<>();
        SLLNode<E> tmp1 = list1.first;
        SLLNode<E> tmp2 = list2.first;

        while(tmp1 != null && tmp2 != null ){

            if(tmp1.element.compareTo(tmp2.element) <0 ){

                rezultantna.insertLast(tmp1.element);
                tmp1 = tmp1.succ;
            }
            else{
                rezultantna.insertLast(tmp2.element);
                tmp2 = tmp2.succ;
            }

        }
        // add in elements that were not added in case 1 list had fewer elements.

        if(tmp1!=null){
            while(tmp1!=null){
                rezultantna.insertLast(tmp1.element);
                tmp1=tmp1.succ;
            }
        }

        if(tmp2!=null){
            while(tmp2!=null){
                rezultantna.insertLast(tmp2.element);
                tmp2 = tmp2.succ;
            }
        }

    return rezultantna;
    }

    public void sllReverseSort(){
         SLLNode<E> node, prev1, prev2, tmp;

        for(int i=0; i<length(); i++){

            node = first.succ;
            prev1 = first;
            prev2 = first;
            while(node != null){
                if(prev1.element.compareTo(node.element) <0){

                    tmp = node.succ;
                    node.succ = prev1;
                    prev1.succ = tmp;
                    if(prev1==first){
                        first=node;
                    }else {
                        prev2.succ = node;
                    }
                    prev2 = node;
                    node = tmp;
                }
                else{
                    if(prev1 != first){
                        prev2=prev2.succ;
                    }
                    prev1=prev1.succ;
                    node=node.succ;
                }
            }
        }
        this.mirror();     // prevrti ja opagjacki sortiranata lista

    }

}


public class PalindromeSLL {

    private static int isPalindrome(SLL<Integer> list){

        SLL<Integer> mirrored = new SLL<>();
        SLLNode<Integer> tmp = list.getFirst();

        while(tmp!=null){

            mirrored.insertLast(tmp.element);
            tmp = tmp.succ;
        }   // tmp here is null, so we set it to point to list.first again (:
        tmp = list.getFirst();
        mirrored.mirror();
        SLLNode<Integer> tmpMirrored = mirrored.getFirst();
        while(tmp!=null && tmpMirrored!=null) {
            if (!(tmp.element.compareTo(tmpMirrored.element) == 0)) {
                return -1;
            }
            tmp = tmp.succ;
            tmpMirrored = tmpMirrored.succ;
        }
        return 1;
    }

    public static void main(String[] args) {

        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();

        lista1.insertLast(1);
        lista1.insertLast(3);
        lista1.insertLast(6);
        lista1.insertLast(8);

        lista2.insertLast(2);
        lista2.insertLast(5);
        lista2.insertLast(9);
        lista1 = lista1.join(lista1,lista2);

        System.out.println(lista1);


    }
}
*/
