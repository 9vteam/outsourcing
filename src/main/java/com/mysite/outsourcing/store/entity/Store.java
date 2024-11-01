package com.mysite.outsourcing.store.entity;


import com.mysite.outsourcing.enums.StoreState;
import com.mysite.outsourcing.menu.entity.Menu;
import com.mysite.outsourcing.order.entity.Order;
import com.mysite.outsourcing.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private Integer minimumAmount;

    @Enumerated(value = EnumType.STRING)
    private StoreState state;

    @OneToMany(mappedBy = "store",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "store",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}
