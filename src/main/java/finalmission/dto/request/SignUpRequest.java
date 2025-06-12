package finalmission.dto.request;

import finalmission.domain.Member;

public record SignUpRequest(String name, String email, String password) {

    public Member toMember() {
        return new Member(null, name, email, password);
    }
}
