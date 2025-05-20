package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Enter your choice: ");
            System.out.println("1: Insert at start");
            System.out.println("2: Insert at end");
            System.out.println("3: Insert at specific position");
            System.out.println("4: Delete frmo start");
            System.out.println("5: Delete from end");
            System.out.println("6: Delete from specific position");
            System.out.println("7: Print list");
            System.out.println("8: Search an element in the list");
            System.out.println("9: Delete entire list");
            System.out.println("10: Quit");
            int c = sc.nextInt();
            int data;

            switch (c) {
                case 1:
                    System.out.println("Enter data:");
                    data = sc.nextInt();
                    sLL.insertAtStart(data);
                    break;

                case 2:
                    System.out.println("Enter data:");
                    data = sc.nextInt();
                    sLL.insertAtEnd(data);
                    break;

                case 3:
                    System.out.println("Enter data and position:");
                    data = sc.nextInt();
                    int pos = sc.nextInt();
                    sLL.insertAtPosition(data, pos);
                    break;

                case 4:
                    sLL.deleteAtStart();
                    break;

                case 5:
                    sLL.deleteAtEnd();
                    break;

                case 6:
                    System.out.println("Enter position:");
                    int del_pos = sc.nextInt();
                    sLL.deleteFromPosition(del_pos);
                    break;

                case 7:
                    sLL.printList();
                    break;

                case 8:
                    System.out.println("Enter element you want to search:");
                    int key = sc.nextInt();
                    sLL.search(key);
                    break;

                case 9:
                    sLL.deleteEntireList();
                    break;

                case 10:
                    System.out.println("You  quit!!!");
                    flag = false;
                    break;

                default:
                    System.out.println("Enter correct number!!!");
                    flag = false;
                    break;
            }
        }
        System.out.println("Program ended");
    }
}
