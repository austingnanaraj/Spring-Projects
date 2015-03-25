package neu.edu.validator;

import neu.edu.lab08.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.name", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Your password Is Incorrenct");
	}

}
