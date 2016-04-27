package springmvc.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springmvc.model.Users;
@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Users.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Users users = (Users) target;
		if(!StringUtils.hasText(users.getUserEmail())){
			errors.rejectValue("userEmail", "error.mailid.notfound");
		}
		if(!StringUtils.hasText(users.getUserPassword())){
			errors.rejectValue("userPassword", "error.password.notfound");
		}
		
	}

}
