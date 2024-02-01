package com.world2meet.superHeroesApi.application.validator;

import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SuperHeroNameValdiator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SuperHeroRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SuperHeroRequest superHeroRequest = (SuperHeroRequest) target;
        if (superHeroRequest.getSuperHeroName().isEmpty()) {
            errors.rejectValue("superHeroName", "field.required", "The field superHeroName is required");
        }
    }
}
