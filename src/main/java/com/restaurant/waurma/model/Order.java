package com.restaurant.waurma.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Table(name = "order")
public class Order {

    @Id
    @NotNull
    @Column(name = "order_id")
    private String id;

    @NotNull
    @NotEmpty
    @Column(name = "weight")
    private String weight;

    @NotNull
    @NotEmpty
    @Column(name = "date")
    private String date;

    @NotNull
    @NotEmpty
    @Column(name = "price")
    private String price;

    @NotNull
    @NotEmpty
    @Column(name = "quantity")
    private String quantity;

    @NotNull
    @Column(name = "ready")
    private boolean ready;

}
