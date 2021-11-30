package kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
class DLLNode<E> {
    protected E element;
    protected int numappearances;

    protected  DLLNode<E> pred, succ;

    public DLLNode(E elem,  DLLNode<E> pred,  DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;

    }

    public E getElement() {
        return element;
    }

    public int getNumappearances() {
        return numappearances;
    }

    public  DLLNode<E> getPred() {
        return pred;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


class DLL<E extends Comparable<E>> {
    private lists.DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            lists.DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public lists.DLLNode<E> find(E o) {
        if (first != null) {
            lists.DLLNode<E> tmp = first;
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

    public void insertFirst(E o) {
        lists.DLLNode<E> ins = new lists.DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else {
            first.pred = ins;
        }
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            lists.DLLNode<E> ins = new lists.DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, lists.DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        lists.DLLNode<E> ins = new lists.DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, lists.DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        lists.DLLNode<E> ins = new lists.DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            lists.DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                lists.DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    public E delete(lists.DLLNode<E> node) {
        if (node == first) {
            deleteFirst();
            return node.element;
        }
        if (node == last) {
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            lists.DLLNode<E> tmp = first;
            ret += tmp + "<->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void setFirst(lists.DLLNode<E> first) {
        this.first = first;
    }

    public void setLast(lists.DLLNode<E> last) {
        this.last = last;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            lists.DLLNode<E> tmp = last;
            ret += tmp + "<->";
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    // RESENIE ZA ZADACA 5
    public void removeDuplicates() {

        if (first != null) {
            lists.DLLNode<E> tmp = first;
            lists.DLLNode<E> tmp2 = tmp.succ;

            while (tmp.succ != null) {
                while (tmp2 != null) {
                    if (tmp.element.compareTo(tmp2.element) == 0) {
                        tmp.numappearances++;
                        if (tmp2.succ != null) {
                            tmp2 = tmp2.succ;
                            this.delete(tmp2.pred);
                        } else {
                            this.delete(tmp2);
                            tmp2 = null;
                        }
                    }
                    else tmp2 = tmp2.succ;
                }
                tmp = tmp.succ;
                if (tmp == null) break;
                tmp2 = tmp.succ;
            }
        }
    }
    public lists.DLLNode<E> getFirst() {
        return first;
    }

    public lists.DLLNode<E> getLast() {

        return last;
    }
}





public class DLLVojska {


    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        DLL<Integer> result = vojska(lista, a, b, c, d);


        DLLNode<Integer> node = result.getFirst();
        System.out.print(node.element);
        node = node.succ;
        while(node != null){
            System.out.print(" "+node.element);
            node = node.succ;
        }

    }

    private static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d) {

        // Vasiot kod tuka
        DLLNode<Integer> node = lista.getFirst();
        DLLNode<Integer> start1 = null, start2 = null, end1 = null, end2 = null,tmp;

        while(node!= null){
            if(node.element.equals(a)){
                start1 = node;
            }
            if(node.element.equals(b)){
                end1 = node;
            }
            if(node.element.equals(c)){
                start2 = node;
            }
            if(node.element.equals(d)){
                end2 = node;
            }
            node = node.succ;
        }

        start2.pred.succ=start1;
        if(start1==lista.getFirst()){
            start1.pred =start2.pred;
            start2.pred = null;
            lista.setFirst(start2);

        } else{
            start1.pred.succ=start2;
            tmp = start1.pred;
            start1.pred=start2.pred;
            start2.pred=tmp;
        }

        end1.succ.pred=end2;
        if(end2 == lista.getLast()){
            end2.succ=end1.succ;
            end1.succ=null;
            lista.setLast(end1);

        }else{
            end2.succ.pred = end1;
            tmp = end1.succ;
            end1.succ = end2.succ;
            end2.succ=tmp;
        }
        return lista;
    }
}
*/


