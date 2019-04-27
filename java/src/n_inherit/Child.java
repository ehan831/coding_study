package n_inherit;

public class Child extends Parent {

    public Child() {
        System.out.println( "자식 생성자" );
    }

    public void gene() {
        System.out.println( "자식은 자식이다" );
    }

    public void study() {
        System.out.println( "자식은 학생" );
    }
}
