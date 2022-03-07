//package com.example.demo.validator;
//
//import com.example.demo.form.CustomerForm;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class CustomerFormValidator implements Validator {
//
//    private final EmailValidator emailValidator = EmailValidator.getInstance();
//
//    // Validator này chỉ dùng để kiểm tra đối với CustomerForm.
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return clazz == CustomerForm.class;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        CustomerForm custInfo = (CustomerForm) target;
//
//        // Kiểm tra các trường (field) của CustomerForm.
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");
//
//        if (!emailValidator.isValid(custInfo.getEmail())) {
//            errors.rejectValue("email", "Pattern.customerForm.email");
//        }
//    }
//
//}
