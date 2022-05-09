package com.adonev.waurma1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Waiter")
@Table(name = "waiter",schema = "public")
public class Waiter {
    public Waiter(){

    }
    public Waiter(String email, String name, String phone) {
        this.waiter_email = email;
        this.waiter_name = name;
        this.waiter_phone = phone;
    }
    @Id
    @NotNull
    @SequenceGenerator(name = "waiter_sequence", sequenceName = "waiter_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "waiter_sequence")
    @Column(name = "waiter_id")
    private Long waiter_id;

    @NotNull
    @NotEmpty
    @Column(name = "waiter_email",columnDefinition = "VARCHAR")
    private String waiter_email;

    @NotNull
    @NotEmpty
    @Column(name = "waiter_name",columnDefinition = "VARCHAR")
    private String waiter_name;

    @NotNull
    @NotEmpty
    @Column(name = "waiter_phone",columnDefinition = "VARCHAR")
    private String waiter_phone;

//    @OneToMany(
//            mappedBy = "waiter",
//            orphanRemoval = true,
//            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//            fetch = FetchType.LAZY
//    )
//    private List<Order> waiterOrders = new ArrayList<>();


    @OneToOne(mappedBy = "waiter", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private WaiterPayCard waiterPayCard;

    @Override
    public String toString() {
        return "Waiter{" +
                "waiter_id=" + waiter_id +
                ", waiter_email='" + waiter_email + '\'' +
                ", waiter_name='" + waiter_name + '\'' +
                ", waiter_phone='" + waiter_phone + '\'' +
                ", waiterPayCard=" + waiterPayCard +
                '}';
    }
}
