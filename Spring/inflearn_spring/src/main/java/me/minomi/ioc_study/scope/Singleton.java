package me.minomi.ioc_study.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */

@Component
public class Singleton {

    @Autowired
    ProtoType proto;

    public ProtoType getProto() {
        return proto;
    }
}
