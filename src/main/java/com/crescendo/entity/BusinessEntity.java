package com.crescendo.entity;

import com.crescendo.DTO.ReviewDTO;
import com.crescendo.model.Review;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

/*    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "business_id")
    private List<ReviewDTO> reviews = new ArrayList<>();*/
}
