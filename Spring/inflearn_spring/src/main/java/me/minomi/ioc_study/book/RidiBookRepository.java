package me.minomi.ioc_study.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */

@Repository @Primary
public class RidiBookRepository implements BookRepository { }
