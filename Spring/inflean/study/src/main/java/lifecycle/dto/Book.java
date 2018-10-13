package lifecycle.dto;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class Book {
    private String id;
    private String title;
    private boolean canRental;
    private Member member;

    public Book(String id, String title, boolean canRental, Member member) {
        this.id = id;
        this.title = title;
        this.canRental = canRental;
        this.member = member;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCanRental() {
        return canRental;
    }

    public void setCanRental(boolean canRental) {
        this.canRental = canRental;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Book id : " + id + " title " + title + " [ " + member + " ] ";
    }
}
