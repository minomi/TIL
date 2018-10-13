package lifecycle.service;

import lifecycle.dao.MemberDao;
import lifecycle.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class MemberSearchService {

    @Autowired
    private MemberDao memberDao;

    public Member search(String id) {
        return memberDao.select(id);
    }

    public void initMethod() {
        System.out.println("MemberSearchService init");
    }

    public void destroyMethod() {
        System.out.println("MemberSearchService Destroy");
    }
}
