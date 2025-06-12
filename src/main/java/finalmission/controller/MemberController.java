package finalmission.controller;

import finalmission.domain.Member;
import finalmission.dto.request.SignUpRequest;
import finalmission.dto.response.SignUpResponse;
import finalmission.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    public ResponseEntity<SignUpResponse> createMember(SignUpRequest request) {
        Member member = memberService.signUp(request);
        SignUpResponse response = SignUpResponse.from(member);

        return ResponseEntity.ok(response);
    }
}
