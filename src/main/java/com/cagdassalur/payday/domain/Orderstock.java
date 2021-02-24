package com.cagdassalur.payday.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Orderstock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="orderstock_id")
    private long orderstockId;

    private BigDecimal cash;

    private String stockSymbol;

    private long stockLot;

    private String orderType;

    private boolean active;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
}