package com.crescendo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDTO {
    private Integer id;
    private Integer businessId;
    private String text;
    private Integer rating;
    private Date createDateTime;
}
