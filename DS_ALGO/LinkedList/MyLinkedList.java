package DS_ALGO.LinkedList;


class Node<T> {
    T value;
    Node<T> next;
    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {

        String next = this.next==null?"NULL":this.next.toString();
        String result = "{\n value: " + this.value + ",\n Next: " + next +"\n}";
        
        return  result;
    }
}

class CustomLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length;
    CustomLinkedList(T firstItem) {
        this.head = new Node<T>(firstItem, null);
        this.tail = head;
        length = 1;

    }

    void append(T item) {
        Node<T> newNode = new Node<T>(item, null);
        this.tail.next = newNode;
        this.tail = newNode; 
        this.length++;
    }

    void prepend(T item) {

        Node<T> newNode = new Node<T>(item, null);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;

    }

    void insert(int index, T item) {
        if(index == 0)
        {
            prepend(item);
        }
        else if(index >= length) {
            append(item);
        }

        else {
            int counter  = 0;
            Node<T> newNode = new Node<T>(item, null);
            Node<T> currentNode = this.head;
            while(true) {
                if(counter == index - 1){
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    length++;
                    break;
                }
                counter++;
                currentNode = currentNode.next;
            }
        }
    }

    T remove(int index) {
        T removedItem = null;
        if(index == 0) {
            removedItem = this.head.value;
            this.head = this.head.next;
            this.length--;
        }

        else {
            // bad approach
            /*
            Node<T> behind = traverseToIndex(index - 1);
            Node<T> ahead = traverseToIndex(index + 1);

            removedItem = behind.next.value;
            behind.next = ahead;
            */

            // Better approach
            Node<T> leader = traverseToIndex(index -1);
            Node<T> unwantedNode = leader.next;
            removedItem = unwantedNode.value;
            leader.next = unwantedNode.next;

        }

        return removedItem;

        
    }

    Node<T> traverseToIndex(int index) {

        Node<T> currentNode = this.head;
        int counter = 0;
        while(counter != index) {

            counter++;
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    void printList() {

        System.out.println(this.head.toString());

    }

    int getLength(){
        return length;
    }
}
public class MyLinkedList {

    public  static void main(String[] args) {
        CustomLinkedList<String> myLinkedList = new CustomLinkedList<String>("Apples");
        myLinkedList.append("Grapes");
        myLinkedList.prepend("Bananas");
        myLinkedList.insert(1, "Oranges");
        myLinkedList.insert(0, "Watermelon");
        myLinkedList.insert(9, "papaya");

        myLinkedList.remove(0);
        myLinkedList.remove(2);
        myLinkedList.printList();
    }


    
}
