package com.adonev.waurma1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.sql.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Order")
@Table(name = "order",schema = "public")
public class Order {

    public Order(){

    }
    public Order(String weight, Date date, String price, String quantity, boolean ready) {
        this.weight = weight;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.ready = ready;
    }

    @Id
    @NotNull
    @SequenceGenerator(name = "order_id_sequence",sequenceName = "order_id_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "order_id_sequence")
    @Column(name = "order_id")
    private String order_id;

    @NotNull
    @NotEmpty
    @Column(name = "weight",columnDefinition = "VARCHAR")
    private String weight;

    @NotNull
    @NotEmpty
    @Column(name = "date",columnDefinition = "DATE")
    private Date date;

    @NotNull
    @NotEmpty
    @Column(name = "price",columnDefinition = "VARCHAR")
    private String price;

    @NotNull
    @NotEmpty
    @Column(name = "quantity",columnDefinition = "varchar")
    private String quantity;

    @NotNull
    @Column(name = "ready",columnDefinition = "bool")
    private boolean ready;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "customer_orders_fk"
            )
    )
    private Customer customer;
    @ManyToOne
    @JoinColumn(
            name = "waiter_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "waiter_orders_fk"
            )
    )
    private Waiter waiter;

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", weight='" + weight + '\'' +
                ", date=" + date +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", ready=" + ready +
                '}';
    }
}

