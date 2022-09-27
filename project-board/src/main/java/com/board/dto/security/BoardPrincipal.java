package com.board.dto.security;

import com.board.dto.UserAccountDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardPrincipal implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String email;
    private String nickname;
    private String memo;

    public static BoardPrincipal of(String username, String password, String email, String nickname, String memo) {
        Set<RoleType> roleTypes = Set.of(RoleType.USER);

        return BoardPrincipal.builder()
                .username(username)
                .password(password)
                .authorities(roleTypes.stream().map(RoleType::getName).map(SimpleGrantedAuthority::new).collect(Collectors.toUnmodifiableSet()))
                .email(email)
                .nickname(nickname)
                .memo(memo)
                .build();
    }

    public static BoardPrincipal from(UserAccountDto dto) {
        return BoardPrincipal.builder()
                .username(dto.getUserId())
                .password(dto.getUserPassword())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .memo(dto.getMemo())
                .build();
    }

    public UserAccountDto toDto() {
        return UserAccountDto.builder()
                .userId(username)
                .userPassword(password)
                .email(email)
                .nickname(nickname)
                .memo(memo)
                .build();
    }

    @Override public boolean isAccountNonExpired() {return true;}
    @Override public boolean isAccountNonLocked() {return true;}
    @Override public boolean isCredentialsNonExpired() {return true;}
    @Override public boolean isEnabled() {return true;}

    @Getter
    public enum RoleType {
        USER("ROLE_USER");

        private final String name;

        RoleType(String name) {
            this.name = name;
        }
    }

}
