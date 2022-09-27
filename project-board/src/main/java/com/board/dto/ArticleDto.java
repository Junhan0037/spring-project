package com.board.dto;

import com.board.domain.Article;
import com.board.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleDto {

    private Long id;
    private UserAccountDto userAccountDto;
    private String title;
    private String content;
    private Set<HashtagDto> hashtagDtos;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public static ArticleDto of(UserAccountDto userAccountDto, String title, String content, Set<HashtagDto> hashtagDtos) {
        return ArticleDto.builder()
                .id(null)
                .userAccountDto(userAccountDto)
                .title(title)
                .content(content)
                .hashtagDtos(hashtagDtos)
                .createdAt(null)
                .createdBy(null)
                .modifiedAt(null)
                .modifiedBy(null)
                .build();
    }

    public static ArticleDto of(Long id, UserAccountDto userAccountDto, String title, String content, Set<HashtagDto> hashtagDtos, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return ArticleDto.builder()
                .id(id)
                .userAccountDto(userAccountDto)
                .title(title)
                .content(content)
                .hashtagDtos(hashtagDtos)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .modifiedAt(modifiedAt)
                .modifiedBy(modifiedBy)
                .build();
    }

    public static ArticleDto from(Article entity) {
        return ArticleDto.builder()
                .id(entity.getId())
                .userAccountDto(UserAccountDto.from(entity.getUserAccount()))
                .title(entity.getTitle())
                .content(entity.getContent())
                .hashtagDtos(entity.getHashtags().stream().map(HashtagDto::from).collect(Collectors.toUnmodifiableSet()))
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .modifiedAt(entity.getModifiedAt())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

    public Article toEntity(UserAccount userAccount) {
        return Article.builder()
                .userAccount(userAccount)
                .title(title)
                .content(content)
                .build();
    }

}
