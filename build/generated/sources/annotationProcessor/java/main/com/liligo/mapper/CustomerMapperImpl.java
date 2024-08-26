package com.liligo.mapper;

import com.liligo.airport_shuttle.model.Customer;
import com.liligo.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T08:58:06+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer map(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( user.getFullName() );
        customer.setEmail( user.getEmail() );
        customer.setPhoneNumber( user.getPhoneNumber() );

        return customer;
    }
}
