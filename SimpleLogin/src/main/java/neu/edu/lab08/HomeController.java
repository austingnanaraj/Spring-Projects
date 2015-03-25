package neu.edu.lab08;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import neu.edu.lab08.dao.UserDao;
import neu.edu.lab08.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * Specify this useValidate will be injected
	 */
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@Autowired
	private UserDao userDao;
	
	/*
	 * This is to initialize webDataBinder,set its
	 * validator as we specify.
	 */
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initUserLoginForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "home";
	}
	
	/*
	 * Process From request
	 */
	@RequestMapping(value="/" ,method=RequestMethod.POST)
	public String submitForm(Model model, @Validated User user, BindingResult result){
		model.addAttribute("user",user);
		String returnVal = "userHomePage";
		if (result.hasErrors()){
			
			return "home";
		}else{
			try {
				User u = userDao.queryUserByNameAndPassword(user.getName(), user.getPassword());
				if (u != null){
					model.addAttribute("user", u);
					return returnVal;		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "home";
		
	}
	
}
