package com.board.config;

import com.board.domain.UserAccount;
import com.board.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class SecurityConfigTest {

    @MockBean
    private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(
                UserAccount.builder()
                        .userId("unoTest")
                        .userPassword("pw")
                        .email("uno-test@email.com")
                        .nickName("uno-test")
                        .memo("test memo")
                        .build()
        ));
    }

}
