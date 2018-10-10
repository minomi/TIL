package testPlj;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 11..
 */
public class Main {
    public static void main(String[] args) {
        // 컨테이너에 접근하기 위한 타입
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        TranspotaionWalk transpotaionWalk = ctx.getBean("tWalk", TranspotaionWalk.class);
        transpotaionWalk.move();
        ctx.close();
    }
}
