package com.board.dto;

import com.board.domain.Hashtag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class HashtagWithArticlesDto {

    private Long id;
    private Set<ArticleDto> articles;
    private String hashtagName;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public static HashtagWithArticlesDto of(Set<ArticleDto> articles, String hashtagName) {
        return new HashtagWithArticlesDto(null, articles, hashtagName, null, null, null, null);
    }

    public static HashtagWithArticlesDto of(Long id, Set<ArticleDto> articles, String hashtagName, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new HashtagWithArticlesDto(id, articles, hashtagName, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static HashtagWithArticlesDto from(Hashtag entity) {
        return HashtagWithArticlesDto.builder()
                .id(entity.getId())
                .articles(entity.getArticles().stream().map(ArticleDto::from).collect(Collectors.toUnmodifiableSet()))
                .hashtagName(entity.getHashtagName())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .modifiedAt(entity.getModifiedAt())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

    public Hashtag toEntity() {
        return Hashtag.builder()
                .hashtagName(hashtagName)
                .build();
    }

}
