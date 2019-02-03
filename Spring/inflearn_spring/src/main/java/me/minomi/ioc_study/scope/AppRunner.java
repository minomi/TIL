package me.minomi.ioc_study.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(ctx.getBean(ProtoType.class));
        System.out.println(ctx.getBean(ProtoType.class));
        System.out.println(ctx.getBean(ProtoType.class));

        Singleton singleton = ctx.getBean(Singleton.class);

        System.out.println(singleton.getProto());
        System.out.println(singleton.getProto());
        System.out.println(singleton.getProto());
    }
}
