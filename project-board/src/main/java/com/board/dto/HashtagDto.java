package com.board.dto;

import com.board.domain.Hashtag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class HashtagDto {

    private Long id;
    private String hashtagName;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public static HashtagDto of(String hashtagName) {
        return new HashtagDto(null, hashtagName, null, null, null, null);
    }

    public static HashtagDto of(Long id, String hashtagName, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new HashtagDto(id, hashtagName, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static HashtagDto from(Hashtag entity) {
        return HashtagDto.builder()
                .id(entity.getId())
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
