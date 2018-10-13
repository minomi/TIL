package lifecycle.dto;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class Member {
    private String id;
    private String pw;
    private String name;

    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member id : " + id + " name : " + name;
    }
}
