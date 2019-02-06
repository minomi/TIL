package me.minomi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-06.
 */
public class MyListenr implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ghgh");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ghgh");
    }
}
