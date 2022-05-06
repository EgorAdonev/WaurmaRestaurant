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
@Table(name = "orderItems")
public class OrderItems {

    @Id
    @NotNull
    @Column(name = "food_id")
    private String food_id;

    @NotNull
    @NotEmpty
    @Column(name = "weight_food")
    private String weight_food;

    @NotNull
    @NotEmpty
    @Column(name = "name_food")
    private String name_food;

    @NotNull
    @NotEmpty
    @Column(name = "price_food")
    private String price_food;
}
