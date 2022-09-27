package com.board.dto;

import com.board.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleWithCommentsDto {

    private Long id;
    private UserAccountDto userAccountDto;
    private Set<ArticleCommentDto> articleCommentDtos;
    private String title;
    private String content;
    private Set<HashtagDto> hashtagDtos;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public static ArticleWithCommentsDto of(Long id, UserAccountDto userAccountDto, Set<ArticleCommentDto> articleCommentDtos, String title, String content, Set<HashtagDto> hashtagDtos, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleWithCommentsDto(id, userAccountDto, articleCommentDtos, title, content, hashtagDtos, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleWithCommentsDto from(Article entity) {
        return ArticleWithCommentsDto.builder()
                .id(entity.getId())
                .userAccountDto(UserAccountDto.from(entity.getUserAccount()))
                .articleCommentDtos(entity.getArticleComments().stream().map(ArticleCommentDto::from).collect(Collectors.toCollection(LinkedHashSet::new)))
                .title(entity.getTitle())
                .content(entity.getContent())
                .hashtagDtos(entity.getHashtags().stream().map(HashtagDto::from).collect(Collectors.toUnmodifiableSet()))
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .modifiedAt(entity.getModifiedAt())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

}
