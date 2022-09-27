package com.board.dto.request;

import com.board.dto.ArticleDto;
import com.board.dto.HashtagDto;
import com.board.dto.UserAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleRequest {

    private String title;
    private String content;

    public static ArticleRequest of(String title, String content) {
        return ArticleRequest.builder()
                .title(title)
                .content(content)
                .build();
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return toDto(userAccountDto, null);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto, Set<HashtagDto> hashtagDtos) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtagDtos
        );
    }

}
