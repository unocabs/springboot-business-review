package com.crescendo.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusinessDTO {
        private Integer id;
        private String businessName;
        private String address;
        private String phone;
}
