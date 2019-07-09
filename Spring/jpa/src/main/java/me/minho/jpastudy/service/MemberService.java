package me.minho.jpastudy.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import me.minho.jpastudy.domain.Member;
import me.minho.jpastudy.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */

@Service
@Transactional
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> members = memberRepository.findByName(member.getName());
        if (!members.isEmpty()) {
            throw new IllegalStateException("회원 중복");
        }
    }
}
