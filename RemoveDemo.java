// RemoveDemo.java
import java.util.NoSuchElementException;

public class RemoveDemo {
    static class Link {
        private Object element;
        private Link next;
        public Link(Object element, Link next) { 
            this.element = element; 
            this.next = next; 
        }
        public Object element() { 
            return element; 
        }
        public Link next() { 
            return next; 
        }
        public void setElement(Object e) { 
            element = e; 
        }
        public void setNext(Link n) { 
            next = n; 
        }
    }

    static class LListRemove {
        private Link head, tail, curr;
        private int listSize;

        public LListRemove() { clear(); }

        public void clear() {
            tail = new Link(null, null);
            head = new Link(null, tail);
            curr = tail;
            listSize = 0;
        }

        public boolean append(Object it) {
            tail.setNext(new Link(null, null));
            tail.setElement(it);
            tail = tail.next();
            listSize++;
            return true;
        }

        public void moveToStart() { curr = head.next(); }

        public Object remove() {
            if (curr == tail) {
                throw new NoSuchElementException("remove(): no current element.");
            }

            Object it = curr.element(); //this will just store the value at that element
            curr.setElement(curr.next().element());

            if (curr.next() == tail) {
                tail = curr;
            }
            curr.setNext(curr.next().next());
            listSize--;
            return it;
        }

        public void display() {
            Link temp = head.next();
            System.out.print("[ ");
            while (temp != tail) {
                System.out.print(temp.element() + " ");
                temp = temp.next();
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        LListRemove list = new LListRemove();
        list.append("A");
        list.append("B");
        list.append("C");

        System.out.print("Before removal: ");
        list.display();
        

        list.moveToStart(); // curr at "A"
        System.out.println("Removed element (should be A): " + list.remove());

        System.out.print("After removal: ");
        list.display();
    }
}