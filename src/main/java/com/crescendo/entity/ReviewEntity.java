package com.crescendo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "business_id")
    private Integer businessId;
    @Column(name = "text")
    private String text;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "created_date_time")
    private Date createdDateTime;
}
