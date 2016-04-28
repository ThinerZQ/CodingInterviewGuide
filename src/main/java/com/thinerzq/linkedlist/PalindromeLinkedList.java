package com.thinerzq.linkedlist;

/**
 * Created by Intellij IDEA
 * Date: 16-4-27
 * Time: 下午9:43
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

import java.util.Stack;

/**
 *  judge the linked list whether is palindrome
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome1(Node head){

        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur!=null) {
            stack.push(cur);
            cur =cur.next;
        }
        while (head!=null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }



    public static boolean isPalindrome1_2(Node head){

        if (head==null || head.next == null) {
            return true;
        }

        Node right = head.next;
        Node cur = head;
        while (cur.next !=null && cur.next.next!=null) {
            cur = cur.next.next;
            right = right.next;
        }

        Stack<Node> stack = new Stack<Node>();
        while (right!=null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
    public static boolean isPalindrome1_3(Node head){

        if (head==null || head.next == null) {
            return true;
        }

        Node right = head.next;
        Node cur = head;
        while (cur.next !=null && cur.next.next!=null) {
            cur = cur.next.next;
            right = right.next;
        }

        Stack<Node> stack = new Stack<Node>();
        while (right!=null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }












    private static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
