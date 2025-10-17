// AppendDemo.java
public class AppendDemo {
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

    static class LListAppend {
        private Link head, tail, curr;
        private int listSize;

        public LListAppend() { clear(); }

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
        LListAppend list = new LListAppend();
        list.append("X");
        list.append("Y");
        list.append("Z");

        System.out.print("After appending (expected X Y Z): ");
        list.display();
    }
}
