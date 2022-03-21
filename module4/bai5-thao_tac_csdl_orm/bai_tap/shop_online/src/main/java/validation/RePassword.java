package validation;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fresher.Team3.DTO.ResgisterDTO;

public class RePassword implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(ResgisterDTO.class);
	}
	@Override
	public void validate(Object obj, Errors errors) {
		ResgisterDTO resgisterDTO = (ResgisterDTO)obj;
		if(!resgisterDTO.getPassword().equals(resgisterDTO.getRePassword())) {
			errors.reject("rePassword","mat khau khong trung");
		}
	}
}
