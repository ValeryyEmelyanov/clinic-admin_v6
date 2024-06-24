package com.springlesson.clinicadmin.examples.repository;

import com.springlesson.clinicadmin.examples.entity.User;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OwnerConverter implements AttributeConverter<User, Integer> {

    @Override
    public Integer convertToDatabaseColumn(User attribute) {
        return attribute.getId();
    }

    @Override
    public User convertToEntityAttribute(Integer dbData) {
        return new User();
    }
}
