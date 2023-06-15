package com.solvd.laba.collections;

/**
 * General Operations of a LinkedList
 * add a node to the end of the list,
 * get phone.xsd at specific index,
 * get the size of the list
 * */

// Custom collection (LinkedList) w/generic type parameter T
// which T can be any object type

public class CustomLinkedList<T> {
    private Node<T> head;   // 'head' is a reference to the first node in the list
    private int size;   // 'size' keeps track off the number of nodes in the list

    // Declaring private static inner class 'Node' w/ generic type parameter T
    private static class Node<T> {
        T data;         // The phone.xsd stored the nodes in the linked list
        Node<T> next;   // The reference to the next node in the list

        // Defining a constructor for the 'Node' class that takes a parameter 'phone.xsd'
        Node(T data) {
            this.data = data;   // Initializing the 'phone.xsd' variable to the value passed in the constructor
            this.next = null;   // Sets the 'next' variable 'null'
        }
    }

    // Public method that adds a new node with specified phone.xsd to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);     // Create a new 'Node' object w/ specified phone.xsd.
        if (head == null) {     // Checks if the 'head' is 'null' indicate that list is empty
            head = newNode;     // If YES 'head' is set to new node.
        } else {
            Node<T> current = head; // Create a new node 'current' and set it to 'head'
            while (current.next != null) {  // loop through Linked List until the next node is 'null'
                current = current.next;     // set current to the next node
            }
            current.next = newNode;     // set the next node after the last node to the new node being added
        }
        size++;     // variable is incremented
    }

    // Defining a public method 'get' that takes an integer parameter 'index'
    // method will return the phone.xsd at the node with specified index in the list.
    public T get(int index) {
        if (index < 0 || index >= size) {  // check if the given index is out of bounds
            throw new IndexOutOfBoundsException();  // throw an exception if the index is out of bounds
        }
        Node<T> current = head;  // set current node to the head node
        for (int i = 0; i < index; i++) {  // loop through the linked list until the current index is reached
            current = current.next;  // set the current node to the next node in the list
        }
        return current.data;  // return the phone.xsd stored in the current node
    }

    // Defining a public method 'size' that returns the number of nodes in the list
    public int size() {
        return size;
    }
}