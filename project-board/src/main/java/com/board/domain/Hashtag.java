package com.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data @Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(columnList = "hashtagName", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
public class Hashtag extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToMany(mappedBy = "hashtags")
    private Set<Article> articles = new LinkedHashSet<>();

    @Column(nullable = false)
    private String hashtagName; // 해시태크 이름

    public static Hashtag of(String hashtagName) {
        return Hashtag.builder()
                .hashtagName(hashtagName)
                .build();
    }

}
