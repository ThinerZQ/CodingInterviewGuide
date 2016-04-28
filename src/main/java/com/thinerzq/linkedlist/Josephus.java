package com.thinerzq.linkedlist;

/**
 * Created by thinerzq on 16-4-27.
 */
public class Josephus {
    public static void main(String[] args) {


        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);
        Node root8 = new Node(8);

        root1.next=root2;
        root2.next =root3;
        root3.next=root4;
        root4.next = root5;
        root5.next = root6;
        root6.next = root7;
        root7.next = root8;
        root8.next = root1;

        System.out.println(josephusKill1(root1,4));




    }
    public static Node josephusKill1(Node head,int m){


        if (head==null || head.next==head || m<1){
            return head;
        }
        Node last = head;

        while (last.next != head){
            last = last.next;
        }
        int count=0;
        while (last != head){
            if (++count == m){

                last.next = head.next;
                count=0;
            }else{
                last = last.next;
            }
            head = last.next;
        }

        return head;
    }
    public static Node josephusKill2(Node head,int m){


        if (head==null || head.next==head || m<1){
            return head;
        }
        Node cur = head.next;
        int temp =1;

        while (cur != head){
            temp++;
            cur = cur.next;
        }
        temp = getLive(temp,m);
        while (--temp!=0){
            head = head.next;
        }

        return head;
    }
    public static int getLive(int i,int m){
        if (i==1){
            return 1;
        }
        return (getLive(i-1,m)+m-1)%i+1;
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
                    '}';
        }
    }
}
