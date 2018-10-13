package lifecycle.dao;

import lifecycle.dto.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class MemberDao {
    private Map<String, Member> db = new HashMap<>();

    public void insert(Member member) {
        db.put(member.getId(), member);
    }

    public Member select(String id) {
        return db.get(id);
    }
}
