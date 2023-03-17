import java.util.*;
import java.util.Scanner;

class Node {
    int data;
    Node prev, next;
    
    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

class DoubleLinkedList {
    Node head;
    
    public DoubleLinkedList() {
        head = null;
    }
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
    }
    
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            head.prev = null;
            return;
        }
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == data) {
                curr.prev.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                return;
            }
            curr = curr.next;
        }
        System.out.println(data + " not found in the list");
    }
    
    public void search(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                System.out.println(data + " found in the list");
                return;
            }
            curr = curr.next;
        }
        System.out.println(data + " not found in the list");
    }
    
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class PT2 {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        int choice, data;
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.println();
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Traverse");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            System.out.println();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    data = scan.nextInt();
                    list.insert(data);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    data = scan.nextInt();
                    list.delete(data);
                    break;
                case 3:
                    System.out.print("Enter data to search: ");
                    data = scan.nextInt();
                    list.search(data);
                    break;
                case 4:
                    list.traverse();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 5);
    }
}
