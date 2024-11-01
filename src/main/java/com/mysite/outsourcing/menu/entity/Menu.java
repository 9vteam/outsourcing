package com.mysite.outsourcing.menu.entity;

import com.mysite.outsourcing.enums.MenuState;
import com.mysite.outsourcing.store.entity.Store;
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
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private MenuState state;
}
