package LinkedList;

// import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        /*
         * SinglyLinkedList sLL = new SinglyLinkedList();
         * 
         * @SuppressWarnings("resource")
         * Scanner sc = new Scanner(System.in);
         * boolean flag = true;
         * 
         * while (flag) {
         * System.out.println("Enter your choice: ");
         * System.out.println("1: Insert at start");
         * System.out.println("2: Insert at end");
         * System.out.println("3: Insert at specific position");
         * System.out.println("4: Delete frmo start");
         * System.out.println("5: Delete from end");
         * System.out.println("6: Delete from specific position");
         * System.out.println("7: Print list");
         * System.out.println("8: Search an element in the list");
         * System.out.println("9: Delete entire list");
         * System.out.println("10: Quit");
         * int c = sc.nextInt();
         * int data;
         * 
         * switch (c) {
         * case 1:
         * System.out.println("Enter data:");
         * data = sc.nextInt();
         * sLL.insertAtStart(data);
         * break;
         * 
         * case 2:
         * System.out.println("Enter data:");
         * data = sc.nextInt();
         * sLL.insertAtEnd(data);
         * break;
         * 
         * case 3:
         * System.out.println("Enter data and position:");
         * data = sc.nextInt();
         * int pos = sc.nextInt();
         * sLL.insertAtPosition(data, pos);
         * break;
         * 
         * case 4:
         * sLL.deleteAtStart();
         * break;
         * 
         * case 5:
         * sLL.deleteAtEnd();
         * break;
         * 
         * case 6:
         * System.out.println("Enter position:");
         * int del_pos = sc.nextInt();
         * sLL.deleteFromPosition(del_pos);
         * break;
         * 
         * case 7:
         * sLL.printList();
         * break;
         * 
         * case 8:
         * System.out.println("Enter element you want to search:");
         * int key = sc.nextInt();
         * sLL.search(key);
         * break;
         * 
         * case 9:
         * sLL.deleteEntireList();
         * break;
         * 
         * case 10:
         * System.out.println("You  quit!!!");
         * flag = false;
         * break;
         * 
         * default:
         * System.out.println("Enter correct number!!!");
         * flag = false;
         * break;
         * }
         * }
         * System.out.println("Program ended");
         */

        // DeleteNodeInSLL.deleteNode(Node node);

        // DoublyLinkedList dLL = new DoublyLinkedList();
        // CircularSinglyLinkedList cLL = new CircularSinglyLinkedList();
        /*
         * CircularDoublyLinkedList cLL = new CircularDoublyLinkedList();
         * 
         * @SuppressWarnings("resource")
         * Scanner sc = new Scanner(System.in);
         * boolean flag = true;
         * 
         * while (flag) {
         * System.out.println("Enter your choice: ");
         * System.out.println("1: Insert at start");
         * System.out.println("2: Insert at end");
         * System.out.println("3: Insert at specific position");
         * System.out.println("4: Delete frmo start");
         * System.out.println("5: Delete from end");
         * System.out.println("6: Delete from specific position");
         * System.out.println("7: Delete entire list");
         * System.out.println("8: Search an element in the list");
         * System.out.println("9: Print list forward");
         * System.out.println("10: Print list backward");
         * System.out.println("11: Quit");
         * int c = sc.nextInt();
         * int data;
         * 
         * switch (c) {
         * case 1:
         * System.out.println("Enter data:");
         * data = sc.nextInt();
         * cLL.insertAtStart(data);
         * break;
         * 
         * case 2:
         * System.out.println("Enter data:");
         * data = sc.nextInt();
         * cLL.insertAtEnd(data);
         * break;
         * 
         * case 3:
         * System.out.println("Enter data and position:");
         * data = sc.nextInt();
         * int pos = sc.nextInt();
         * cLL.insertAtPosition(data, pos);
         * break;
         * 
         * case 4:
         * cLL.deleteAtStart();
         * break;
         * 
         * case 5:
         * cLL.deleteAtEnd();
         * break;
         * 
         * case 6:
         * System.out.println("Enter position:");
         * int del_pos = sc.nextInt();
         * cLL.deleteFromPosition(del_pos);
         * break;
         * 
         * case 7:
         * cLL.deleteEntireList();
         * break;
         * 
         * case 8:
         * System.out.println("Enter element you want to search:");
         * int key = sc.nextInt();
         * cLL.search(key);
         * break;
         * 
         * case 9:
         * cLL.printForward();
         * break;
         * 
         * case 10:
         * cLL.printBackward();
         * break;
         * 
         * case 11:
         * System.out.println("You  quit!!!");
         * flag = false;
         * break;
         * 
         * default:
         * System.out.println("Enter correct number!!!");
         * flag = false;
         * break;
         * }
         * }
         * System.out.println("Program ended");
         */

        // Reverse Linked List
        // LLNode head = new LLNode(1);
        // head.next = new LLNode(3);
        // head.next.next = new LLNode(2);
        // head.next.next.next = new LLNode(4);

        // System.out.print("Original Linked List: ");
        // printLinkedList(head);

        // // Reverse the linked list
        // head = ReverseLinkedList.optimalRecursiveApproach(head);

        // // Print the reversed linked list
        // System.out.print("Reversed Linked List: ");
        // printLinkedList(head);

        // Reverse Doubly Linked List
        int[] arr = { 12, 5, 6, 8, 4 };
        DLNode head = DLNode.convertArr2DLL(arr);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = ReverseDoublyLinkedList.bruteForceApproach(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);

    }

    public static void printLinkedList(LLNode head) {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void printLinkedList(DLNode head) {
        DLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
