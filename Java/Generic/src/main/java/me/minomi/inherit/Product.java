package me.minomi.inherit;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class Product<K, M> {
    private K kind;
    private M model;

    public Product(K kind, M model) {
        this.kind = kind;
        this.model = model;
    }
}
