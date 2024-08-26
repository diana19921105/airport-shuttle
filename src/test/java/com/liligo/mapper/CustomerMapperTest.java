package com.liligo.mapper;

import com.liligo.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {

    private CustomerMapper customerMapper;

    @BeforeEach
    public void init() {
        customerMapper = new CustomerMapperImpl();
    }


    @Test
    void mapTest() {
        var user = createEntity();
        var mapped = customerMapper.map(user);

        assertAll(
            () -> assertEquals(user.getFullName(), mapped.getName()),
            () -> assertEquals(user.getPhoneNumber(), mapped.getPhoneNumber()),
            () -> assertEquals(user.getEmail(), mapped.getEmail())
        );
    }

    private UserEntity createEntity() {
        return UserEntity.builder()
            .fullName("Tapsi Füles")
            .phoneNumber("+3630 123 4567")
            .email("tapsi@hapsi.com")
            .build();
    }

}
