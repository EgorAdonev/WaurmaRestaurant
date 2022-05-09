package com.adonev.waurma1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "FoodItem")
@Table(name = "food_item",schema = "public")
public class FoodItem {
    public FoodItem(){

    }
    public FoodItem(String weight_food, String name_food, String price_food) {
        this.food_item_id = food_item_id;
        this.weight_food = weight_food;
        this.name_food = name_food;
        this.price_food = price_food;
    }

    @Id
    @NotNull
    @SequenceGenerator(name = "food_item_sequence", sequenceName = "food_item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "food_item_sequence")
    @Column(name = "food_item_id")
    private String food_item_id;
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
