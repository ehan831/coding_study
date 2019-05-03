package q_collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {
    public static void main(String[] args) {

        // Stack - LIFO
        Stack stack = new Stack( );
        stack.push( "A" );
        stack.push( "B" );
        stack.push( "C" );
        while (!stack.isEmpty( )) {
            System.out.println( stack.pop( ) );
        }
//        stack.pop();    // 다 뽑고나서 또 뽑으려고 하면?  EmptyStackException


        Queue queue = new LinkedList( );
        queue.offer( "가" );
        queue.offer( "나" );
        queue.offer( "다" );
        while (!queue.isEmpty( )) {
            System.out.println( queue.poll( ) );
        }
    }
}
