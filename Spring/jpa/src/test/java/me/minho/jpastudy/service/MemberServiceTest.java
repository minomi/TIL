package me.minho.jpastudy.service;

import me.minho.jpastudy.domain.Member;
import me.minho.jpastudy.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.metal.MetalMenuBarUI;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("OH");

        //When
        Long saveId = memberService.join(member);

        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원방지() {
        //Given
        Member member1 = new Member();
        member1.setName("oh");

        Member member2 = new Member();
        member2.setName("oh");

        memberService.join(member1);
        memberService.join(member2);

        fail("예외 발생 안함ㅜㅜ");
    }

}