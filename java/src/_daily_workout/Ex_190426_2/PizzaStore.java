package _daily_workout.Ex_190426_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PizzaStore {

    static ArrayList<String> orderList = new ArrayList<String>( 3 );
    static int totalPrice = 0;

    private static void setOrderList(String pizza_name) {
        orderList.add( pizza_name );
    }


    private static int getTotalPrice() {
        HashMap<String, Integer> pizzaList = new HashMap<>( );
        pizzaList.put( "Cheese", 10000 );
        pizzaList.put( "Potato", 12000 );
        pizzaList.put( "Pineapple", 12000 );
        pizzaList.put( "Meatball", 15000 );

        for(int i=0; i < orderList.size(); i++) {
            totalPrice += pizzaList.get(orderList.get(i)+"");
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        int sel;
        String pizza_name;

        System.out.println( "피자추가(1), 종료(2)" );
        sel = input.nextInt( );

        while (sel == 1) {
            System.out.println( "Cheese, Potato, Pineapple, Meatball" );
            pizza_name = input.next( );
            input.nextLine();
            setOrderList(pizza_name);

            System.out.println( "피자추가(1), 종료(2)" );
            sel = input.nextInt( );
            input.nextLine();

            if (sel == 2) break;
        }
        System.out.println( orderList );
        getTotalPrice();
        System.out.println( totalPrice );
    }
}
