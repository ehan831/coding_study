package c_control;

//public class Ex11_Break_Continue {
//    public static void main(String[] args) {
//        for(int i=0; i<2; i++) {
//            for(int j=0; j<3; j++) {
//                if(j==1) break;
//                System.out.println("<" + i + "," +j + ">");
//            }
//            System.out.println("데이타");
//        }
//    }
//}

/**break END*/
//public class Ex11_Break_Continue {
//    public static void main(String[] args) {
//        END:
//        for(int i=0; i<2; i++) {
//            for(int j=0; j<3; j++) {
//                if(j==1) break END;
//                System.out.println("<" + i + "," +j + ">");
//            }
//            System.out.println("데이타");
//        }
//        // >> 여기까지 쑥 나옴
//    }
//}

/** continue */
//public class Ex11_Break_Continue {
//    public static void main(String[] args) {
//        for(int i=0; i<2; i++) {
//            for(int j=0; j<3; j++) {
//                if(j==1) continue;
//                System.out.println("<" + i + "," +j + ">");
//            }
//            System.out.println("데이타");
//        }
//    }
//}


/**continue END*/
public class Ex11_Break_Continue {
    public static void main(String[] args) {
        END:
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
                if(j==1) continue END;
                System.out.println("<" + i + "," +j + ">");
            }
            System.out.println("데이타");
        }
    }
}