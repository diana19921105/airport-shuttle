package com.liligo.mapper;

import com.liligo.airport_shuttle.model.Customer;
import com.liligo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface CustomerMapper {

    @Mapping(target = "name", source = "fullName")
    Customer map(UserEntity user);

}
