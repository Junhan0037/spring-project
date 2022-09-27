package com.board.dto.request;

import com.board.dto.ArticleCommentDto;
import com.board.dto.UserAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleCommentRequest {

    private Long articleId;
    private String content;

    public static ArticleCommentRequest of(Long articleId, String content) {
        return ArticleCommentRequest.builder()
                .articleId(articleId)
                .content(content)
                .build();
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.builder()
                .articleId(articleId)
                .userAccountDto(userAccountDto)
                .content(content)
                .build();
    }

}
