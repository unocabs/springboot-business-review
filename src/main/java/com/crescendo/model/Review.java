package com.crescendo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
   private Integer businessId;
   private String text;
   private Integer rating;
   private Date createDateTime;
}
