package com.mysite.outsourcing.store.entity;


import com.mysite.outsourcing.enums.StoreState;
import com.mysite.outsourcing.enums.UserState;
import com.mysite.outsourcing.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(updatable = false)
    private LocalDateTime openedAt;

    @Column
    private LocalDateTime closedAt;

    @Column
    private Integer minAmount;

    @Enumerated(value = EnumType.STRING)
    private StoreState state;
}
