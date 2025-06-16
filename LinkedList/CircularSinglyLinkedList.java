package LinkedList;

class CircularNode {
    int data;
    CircularNode next;
    CircularNode prev;

    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedList {
    CircularNode head, tail;

    public CircularSinglyLinkedList() {
        head = tail = null;
    }

    // Create doubly linked list
    public void createList(int data) {
        CircularNode newNode = new CircularNode(data);
        head = tail = newNode;
        newNode.next = head;
    }

    // Insert at beginning
    public void insertAtStart(int data) {
        if (head == null) {
            createList(data);
            return;
        }
        CircularNode newNode = new CircularNode(data);
        newNode.next = head;
        head = newNode;
        tail.next = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        if (tail == null) {
            createList(data);
            return;
        }

        CircularNode newNode = new CircularNode(data);
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int pos) {
        if (pos == 0) {
            insertAtStart(data);
            return;
        }

        CircularNode newNode = new CircularNode(data);
        CircularNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }

    // Delete from beginning
    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    // Delete from end
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            head = tail = null;
            return;
        }

        CircularNode temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    // Delete from specific position
    public void deleteFromPosition(int pos) {
        if (pos == 0) {
            deleteAtStart();
            return;
        }

        CircularNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        if (temp.next == tail) {
            tail = temp;
        }
    }

    // Delete entire list
    public void deleteEntireList() {
        head = null;
        tail = null;
    }

    // Print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        CircularNode temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("null");
    }

    // Size of list
    public int size() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        }
        CircularNode temp = head;
        int count = 0;
        do {
            temp = temp.next;
            count++;
        } while (temp != head);
        System.out.println("Size of the list : " + count);
        return count;
    }

    // Search in the list
    public boolean search(int key) {
        CircularNode temp = head;
        int i = 0;
        do {
            if (temp.data == key) {
                System.out.println(key + " is found at location: " + i);
                return true;
            }
            temp = temp.next;
            i++;
        } while (temp != head);

        System.out.println("Node not found!!");
        return false;
    }
}
