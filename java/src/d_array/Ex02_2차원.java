package d_array;

/**
 * 2차원 배열은 행 열 개념이 아니다.
 * ㅁ--->ㅁㅁㅁㅁ
 * ㅁ--->ㅁㅁㅁㅁ
 * ㅁ--->ㅁㅁㅁㅁ
 * 이런 느낌이다. 앞에 ㅁ에 4개짜리 해당 주소가 각각!!
 */
public class Ex02_2차원 {
    public static void main(String[] args) {
        int[][] score = new int[3][4];

        score[1][2] = 100;
        score[2][3] = 100;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println( i + "행" + j + "열" + score[i][j] );
            }
        }
    }
}
