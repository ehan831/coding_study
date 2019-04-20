package d_array;

/**-----------------------------------------------------
버블 정렬 외에도
 삽입 정렬, 선택 정렬, 퀵 정렬, 힙 정렬, 머지 정렬 공부해보기
 -----------------------------------------------------*/

public class Ex04_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {22, 15, 13, 7, 35, 25};

        for (int i=(arr.length-1); i>0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println( i );
        }
    }
}
