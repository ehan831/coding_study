package ex3_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
    private String name;
    private String message;

    @Autowired
    @Qualifier("outputer2")
//    @Resource(name="outputer2")   // Autowired + Qualifier 조합을 대체
    private Outputer out;
    // 값 지정 // 1.생성자 // 2.setter // 3.autowired

    public MessageBeanImpl() {

    }

    public MessageBeanImpl(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public void sayHello() {
        System.out.println( name + " 님에게 " + message );
        try {
            out.writeMessage( name + " 님께 " + message );
        } catch (IOException e) {
            e.printStackTrace( );
        }
    }
}
