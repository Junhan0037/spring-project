package com.board.domain;

import lombok.*;

import javax.persistence.*;

@Data @Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
public class UserAccount extends AuditingFields {

    @Id @Column(length = 50)
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String nickName;

    private String memo;

}
