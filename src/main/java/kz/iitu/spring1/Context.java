package kz.iitu.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private static Context instance;
    private Context(){}
    public static Context getContext(){
        if (instance == null){
            instance = new Context();
        }
        return instance;
    }
}
