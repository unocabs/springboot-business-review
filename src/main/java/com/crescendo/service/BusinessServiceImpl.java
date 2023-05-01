package com.crescendo.service;

import com.crescendo.DTO.BusinessDTO;
import com.crescendo.entity.BusinessEntity;
import com.crescendo.model.Business;
import com.crescendo.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl {

    private final BusinessRepository businessRepository;
    private final ModelMapper modelMapper;

    public List<BusinessDTO> getAllBusiness() {
        /*List<BusinessEntity> businessEntities = businessRepository.findAll();
        List<BusinessDTO> businessDTOList = new ArrayList<>();

        businessEntities.forEach(businessEntity -> businessDTOList.add(BusinessDTO.builder()
                        .id(businessEntity.getId())
                        .businessName(businessEntity.getBusinessName())
                        .address(businessEntity.getAddress())
                        .phone(businessEntity.getPhone())
                        .reviews(businessEntity.getReviews())
                .build()));
        return businessDTOList;*/
        return businessRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BusinessDTO getBusinessById(Integer id) {
        /*BusinessEntity businessEntity = businessRepository.findBusinessById(id);
        BusinessDTO businessDTO = BusinessDTO.builder()
                .id(businessEntity.getId())
                .businessName(businessEntity.getBusinessName())
                .address(businessEntity.getAddress())
                .phone(businessEntity.getPhone())
                .reviews(businessEntity.getReviews())
                .build();
        return businessDTO;*/
        BusinessEntity businessEntity = businessRepository.findBusinessById(id);

        return convertToDTO(businessEntity);
    }

    public List<BusinessDTO> addBusiness(Business business) {
        /*businessRepository.save(BusinessEntity.builder()
                        .businessName(business.getBusinessName())
                        .address(business.getAddress())
                        .phone(business.getPhone())
                .build());
        return getAllBusiness();*/
        businessRepository.save(convertToEntity(business));

        return getAllBusiness();
    }

    public List<BusinessDTO> updateBusinessById(Integer id, Business updatedBusiness) {
        BusinessEntity businessEntity = businessRepository.findBusinessById(id);

        businessEntity.setBusinessName(updatedBusiness.getBusinessName());
        businessEntity.setAddress(updatedBusiness.getAddress());
        businessEntity.setPhone(updatedBusiness.getPhone());

        businessRepository.save(businessEntity);

        return getAllBusiness();
    }

    public void deleteBusiness(Integer id) {
        BusinessEntity businessEntity = businessRepository.findBusinessById(id);
        businessRepository.delete(businessEntity);

    }

    private BusinessEntity convertToEntity(Business business) { return modelMapper.map(business, BusinessEntity.class);}
    private BusinessDTO convertToDTO(BusinessEntity businessEntity) { return modelMapper.map(businessEntity, BusinessDTO.class); }

}
