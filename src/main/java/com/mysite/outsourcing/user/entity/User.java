package com.mysite.outsourcing.user.entity;

import com.mysite.outsourcing.common.entity.Timestamped;
import com.mysite.outsourcing.enums.AuthType;
import com.mysite.outsourcing.store.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 정보를 담는 Entity 클래스
 *
 * @since 2024-10-03
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Enumerated(value = EnumType.STRING)
    private AuthType type;

    @Column(updatable = false)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    private List<Store> stories = new ArrayList<>();
}
