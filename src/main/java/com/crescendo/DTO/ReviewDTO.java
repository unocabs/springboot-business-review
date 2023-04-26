package com.crescendo.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReviewDTO {
    private Integer id;
    private Integer businessId;
    private String text;
    private Integer rating;
    private Date createDateTime;
}
