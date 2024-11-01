package com.mysite.outsourcing.order.entity;

import com.mysite.outsourcing.enums.OrderState;
import com.mysite.outsourcing.enums.StoreState;
import com.mysite.outsourcing.store.entity.Store;
import com.mysite.outsourcing.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 100)
    private String menuName;

    @Column
    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private OrderState state;
}
