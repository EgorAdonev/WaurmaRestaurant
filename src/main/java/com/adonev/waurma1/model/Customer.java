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
@Table(name = "customer",schema = "public")
@Entity(name = "Customer")
public class Customer {
    public Customer(){

    }
    public Customer(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
    @Id
    @NotNull
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "customer_id_sequence")
    @Column(name = "customer_id")
    private Long customer_id;

    @NotNull
    @NotEmpty
    @Column(name = "email",columnDefinition = "VARCHAR")
    private String email;

    @NotNull
    @NotEmpty
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;

    @NotNull
    @NotEmpty
    @Column(name = "phone",columnDefinition = "VARCHAR")
    private String phone;

    @OneToMany(
            mappedBy = "customer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Order> customerOrders = new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
