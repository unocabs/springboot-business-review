package com.crescendo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
public class BusinessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

}
