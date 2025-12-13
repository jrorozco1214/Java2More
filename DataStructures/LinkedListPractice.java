package DataStructures;
import java.util.NoSuchElementException;

import TestPractice.book;

public class LinkedListPractice {

    public static class Node {
        private Object element;
        private Node next;

        public Node(Object element, Node next){
            this.element = element;
            this.next = next;
        }

        public Object getElement(){
            return this.element;
        }

        public Node next(){
            return this.next;
        }

        public void setElement(Object element){
            this.element = element;
        }

        public void setNext(Node n){
            this.next = n;
        }


    }

    public static class Links{

        private Node head, tail, curr;
        private int listSize;

        public Links(){
            clear(); //the clear allows you reset the link list back to empty and not create a new one and 
            //just use the same object
        }

        public void clear(){
            tail = new Node(null, null);
            head = new Node(null, tail);
            curr = tail;
            listSize = 0;
        }

        public boolean append(Object x){
            tail.setNext(new Node(null, null));
            tail.setElement(x);
            tail = tail.next();
            listSize++;
            return true;
        }

        public boolean insert(Object x){
            curr.setNext(new Node(curr.getElement(), curr.next()));
            curr.setElement(x);

            if(curr == tail){
                tail = curr.next();
            }
            listSize++;
            return true;

        }

         public Object remove() {
            if (curr == tail) {
                throw new NoSuchElementException("remove(): no current element.");
            }

            Object it = curr.getElement();
            curr.setElement(curr.next().getElement());

            if (curr.next() == tail) {
                tail = curr;
            }
            curr.setNext(curr.next().next());
            listSize--;
            return it;
        }

        public void display(){
            Node temp = head.next();
            while(temp != tail){
                System.out.println(temp.getElement());
                temp = temp.next();
            }
        }

        public boolean moveCurr(int x){
            if(x < 0 || x > listSize){
                return false;
            } else{
                curr = head.next();
                for(int i = 0; i < x; i++){
                    curr = curr.next();
                }
            }
            return true;
        }

        public boolean insertAt(Object x, int y, int num){

            if(y < 0 || y > listSize){
                return false;
            }
            Node temp = head.next();
            int counter = 0;

            while(counter <=  y){
                if(counter == y){
                    temp.setNext(new Node(temp.getElement(), temp.next()));
                    temp.setElement(num);

                    if(temp == tail){
                        tail = tail.next();
                    }
                    listSize++;
                } 
                counter++;
                temp = temp.next();
            }
            return true;
        }

        public void moveToStart(){
            curr = head.next();
        }

    }

    public static void main(String[] args) {
        Links linkList = new Links();
        linkList.append(15);
        linkList.append(78);
        linkList.append(97);

        //linkList.display();
        linkList.insert(2);

        //linkList.display();
        System.out.println(linkList.moveCurr(2));

        linkList.insert(4);
        //linkList.display();

        linkList.insertAt(linkList, 3, 36);
        linkList.display();

    }
    
}
