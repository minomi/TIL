package me.minomi.inherit;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class ChildProduct <K, M, C> extends Product<K, M> {
    private C company;

    public ChildProduct(K kind, M model, C company) {
        super(kind, model);
        this.company = company;
    }
}
