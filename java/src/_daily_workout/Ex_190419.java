package _daily_workout;

import java.util.Calendar;

import static sun.swing.MenuItemLayoutHelper.max;

public class Ex_190419 {
    public static void main(String[] args) {
        /**-----------------------------------------------------
         오늘 요일 찍기, 한글로!!
         -----------------------------------------------------*/
//        String[] days = {"일", "월", "화", "수", "목", "금", "토"};
//
//        Calendar c = Calendar.getInstance();
//        System.out.println(days[c.get( Calendar.DAY_OF_WEEK )-1] + "요일" );


        /**-----------------------------------------------------
         [문제]
        동적크기로 합이 가장 큰 행을 출력하기
        int a[][]=new int[][]{{3,-5, 12 }, {-2, 11, 2, -7}, {21, -21, -35, -93, -11}, {9, 14, 39, -98}};
        결과 : 0행
         -----------------------------------------------------*/
        int[][] a = {{3,-5, 12}, {-2, 11, 2, -7}, {21, -21, -35, -93, -11}, {9, 14, 39, -98}};

        int[] sum_array = new int[a.length];
        for(int i=0; i<a.length; i++) {
            int sum=0;
            for(int j=0; j<a[i].length; j++) {
                sum += a[i][j];
            }
            sum_array[i] =sum;
        }

        // MAX 구하기1
        System.out.println(max(sum_array) );

        // MAX 구하기2
        int max = sum_array[0];
        int temp = 0;
        for(int i=1; i<sum_array.length; i++) {
            if(sum_array[i] > max) {
                max = sum_array[i];
            }
        }
        System.out.println(max);








        /**-----------------------------------------------------
               [ 문제 ]: 합이 가장 큰 행과 열
       다음 배열 a에서 합이 가장 큰 행과 열의 번호를 각각 출력하기
       int a[][]=new int[][]{{3,-5, 12, 3, -21}, {-2, 11, 2, -7, -11}, {21, -21, -35, -93, -11}, {9, 14, 39, -98, -1}};
       결과 : 2 1
         -----------------------------------------------------*/


    }
}
