import java.util.Scanner;
import java.util.StringTokenizer;

public class test111 {
    public static void main(String[] args) {

        // 1.컴퓨터 랜덤 수 3개 만들기
        int baseball[] = new int[3];
        for(int i = 0; i<baseball.length; i++ ) {
            baseball[i]= (int)(Math.random()*10);
            for(int j=0; j<i; j++) {
                if(baseball[i] == baseball[j]) {
                    j--;
                }
            }
        }

        for(int i = 0; i<baseball.length; i++ ) {
            System.out.println(baseball[i]);
        }


        //for(int n=0; n<10; n++) {
        // 2. 사용자가 입력한 답을 answer에 각각 담기

        int answer[] = new int[3];

        Scanner input = new Scanner(System.in);

        System.out.println("점수 3개 입력 (ex) 1 2 8");
        String na = input.nextLine();

        StringTokenizer st = new StringTokenizer(na);
        for(int i=0; st.hasMoreTokens(); i++) {
            answer[i] = Integer.parseInt(st.nextToken());

        }System.out.println( answer );

        // 3. baseball 배열과 answer배열을 각각 비교
        int strike=0, ball=0;
        for( int i=0; i<baseball.length; i++) {
            for( int j=0; j<answer.length; j++) {
                //같은 값이라면
                //자리 위치까지 같다면 strike++
                //위치는 다르면 ball++
                // 3 strike라면 반복문 좋료
                ////if()
            }
        }
        //}
        System.out.println("");

    }
}
