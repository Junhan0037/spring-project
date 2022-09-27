package com.board.dto.response;

import com.board.dto.ArticleDto;
import com.board.dto.HashtagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleResponse {

    private Long id;
    private String title;
    private String content;
    private Set<String> hashtags;
    private LocalDateTime createdAt;
    private String email;
    private String nickname;

    public static ArticleResponse of(Long id, String title, String content, Set<String> hashtags, LocalDateTime createdAt, String email, String nickname) {
        return ArticleResponse.builder()
                .id(id)
                .title(title)
                .content(content)
                .hashtags(hashtags)
                .createdAt(createdAt)
                .email(email)
                .nickname(nickname)
                .build();
    }

    public static ArticleResponse from(ArticleDto dto) {
        String nickname = dto.getUserAccountDto().getNickname();
        if (StringUtils.isEmpty(nickname)) {
            nickname = dto.getUserAccountDto().getUserId();
        }

        return ArticleResponse.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .hashtags(dto.getHashtagDtos().stream().map(HashtagDto::getHashtagName).collect(Collectors.toUnmodifiableSet()))
                .createdAt(dto.getCreatedAt())
                .email(dto.getUserAccountDto().getEmail())
                .nickname(nickname)
                .build();
    }

}
