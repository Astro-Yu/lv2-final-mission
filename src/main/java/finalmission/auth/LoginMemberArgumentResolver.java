package finalmission.auth;

import finalmission.domain.Member;
import finalmission.infrastructure.jwt.CookieTokenExtractor;
import finalmission.infrastructure.jwt.JwtTokenProvider;
import finalmission.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

    private final MemberService memberService;
    private final JwtTokenProvider tokenProvider;
    private final CookieTokenExtractor cookieTokenExtractor;

    public LoginMemberArgumentResolver(final MemberService memberService, final JwtTokenProvider tokenProvider,
                                       final CookieTokenExtractor cookieTokenExtractor) {
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
        this.cookieTokenExtractor = cookieTokenExtractor;
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.getParameterType().equals(Member.class);
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter,
                                  final ModelAndViewContainer mavContainer,
                                  final NativeWebRequest webRequest,
                                  final WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String token = cookieTokenExtractor.extract(request)
                .orElseThrow();

        Long id = Long.parseLong(tokenProvider.extractSubject(token));

        return memberService.findMemberById(id);
    }
}
