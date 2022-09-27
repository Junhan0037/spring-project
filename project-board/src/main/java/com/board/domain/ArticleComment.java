package com.board.domain;

import lombok.*;

import javax.persistence.*;

@Data @Builder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(indexes = {
    @Index(columnList = "content"),
    @Index(columnList = "createdAt"),
    @Index(columnList = "createdBy")
})
public class ArticleComment extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Article article; // 게시글 (ID)

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private UserAccount userAccount; // 유저 정보 (ID)

    @Column(nullable = false, length = 500)
    private String content; // 본문

}
