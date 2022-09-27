package com.board.dto.response;

import com.board.dto.ArticleWithCommentsDto;
import com.board.dto.HashtagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleWithCommentsResponse {

    private Long id;
    private String title;
    private String content;
    private Set<String> hashtags;
    private LocalDateTime createdAt;
    private String email;
    private String nickname;
    private String userId;
    private Set<ArticleCommentResponse> articleCommentsResponse;

    public static ArticleWithCommentsResponse of(Long id, String title, String content, Set<String> hashtags, LocalDateTime createdAt, String email, String nickname, String userId, Set<ArticleCommentResponse> articleCommentResponses) {
        return ArticleWithCommentsResponse.builder()
                .id(id)
                .title(title)
                .content(content)
                .hashtags(hashtags)
                .createdAt(createdAt)
                .email(email)
                .nickname(nickname)
                .userId(userId)
                .articleCommentsResponse(articleCommentResponses)
                .build();
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.getUserAccountDto().getNickname();
        if (StringUtils.isEmpty(nickname)) {
            nickname = dto.getUserAccountDto().getUserId();
        }

        return ArticleWithCommentsResponse.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .hashtags(dto.getHashtagDtos().stream().map(HashtagDto::getHashtagName).collect(Collectors.toUnmodifiableSet()))
                .createdAt(dto.getCreatedAt())
                .email(dto.getUserAccountDto().getEmail())
                .nickname(nickname)
                .userId(dto.getUserAccountDto().getUserId())
                .articleCommentsResponse(dto.getArticleCommentDtos().stream().map(ArticleCommentResponse::from).collect(Collectors.toCollection(LinkedHashSet::new)))
                .build();
    }

}
