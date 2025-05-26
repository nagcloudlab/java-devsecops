package com.example;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing elements: " + stack);
        // Peek at the top element
        int topElement = stack.peek();
        System.out.println("Top element after peek: " + topElement);
        // Pop an element from the stack
        while (!stack.isEmpty()) {
            int poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);
            System.out.println("Stack after popping: " + stack);
        }

    }
}
