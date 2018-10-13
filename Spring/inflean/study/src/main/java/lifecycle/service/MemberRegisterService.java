package lifecycle.service;

import lifecycle.dao.MemberDao;
import lifecycle.dto.Member;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class MemberRegisterService implements InitializingBean, DisposableBean {

    @Autowired
    private MemberDao memberDao;

    public void register(Member member) {
        memberDao.insert(member);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MemberRegisterService Destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MemberRegisterService Init");
    }
}
