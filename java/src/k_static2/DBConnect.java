package k_static2;

public class DBConnect {

    static DBConnect db;

    private DBConnect(){    // private 만 지우면 문제가 없다!!!!
        System.out.println("실제로 디비에 연결을 얻어옴");
    }

    public static DBConnect getInstance() {
        if( db==null ) {
            db = new DBConnect();
        }return db;
    }
}
//
//    public class DBConnect {
//
//        DBConnect(){
//            System.out.println("실제로 디비에 연결을 얻어옴");
//        }
//
//    }