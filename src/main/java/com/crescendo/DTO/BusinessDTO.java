package com.crescendo.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class BusinessDTO {
        private Integer id;
        private String businessName;
        private String address;
        private String phone;
        private List reviews;
}
