package com.adonev.waurma1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
@Getter
@Setter
@Entity(name = "WaiterPayCard")
@Table(name = "waiter_pay_card",schema = "public")
public class WaiterPayCard {
    public WaiterPayCard() {

    }

    public WaiterPayCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public WaiterPayCard(String cardNumber, Waiter waiter) {
        this.cardNumber = cardNumber;
        this.waiter = waiter;
    }
    @Id
    @SequenceGenerator(name = "waiter_card_id_sequence", sequenceName = "waiter_card_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "waiter_card_id_sequence")
    @Column(name = "waiter_card_id", updatable = false)
    private Long waiter_card_id;

    @Column(name = "card_number", nullable = false, length = 15)
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "waiter_id",
            referencedColumnName = "waiter_card_id",
            foreignKey = @ForeignKey(name = "waiter_id_fk")
    )
    private Waiter waiter;

}
