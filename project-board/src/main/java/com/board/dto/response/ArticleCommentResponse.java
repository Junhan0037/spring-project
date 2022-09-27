package com.board.dto.response;

import com.board.dto.ArticleCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleCommentResponse {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String email;
    private String nickname;
    private String userId;

    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname, String userId) {
        return ArticleCommentResponse.builder()
                .id(id)
                .content(content)
                .createdAt(createdAt)
                .email(email)
                .nickname(nickname)
                .userId(userId)
                .build();
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String nickname = dto.getUserAccountDto().getNickname();

        if (nickname == null || nickname.isBlank()) {
            nickname = dto.getUserAccountDto().getUserId();
        }

        return ArticleCommentResponse.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .createdAt(dto.getCreatedAt())
                .email(dto.getUserAccountDto().getEmail())
                .nickname(nickname)
                .userId(dto.getUserAccountDto().getUserId())
                .build();
    }


}
