package finalmission.service;

import finalmission.domain.Member;
import finalmission.dto.request.SignUpRequest;
import finalmission.infrastructure.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member signUp(SignUpRequest request) {
        Member member = request.toMember();
        return memberRepository.save(member);
    }
}
