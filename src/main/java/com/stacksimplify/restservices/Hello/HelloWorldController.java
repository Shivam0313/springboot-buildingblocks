package com.stacksimplify.restservices.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	
//@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}
	@GetMapping("/helloworldbean")
	public UserDetails helloWorldBean() {
		return new UserDetails("shivam","singh","jaunpur");
	}
	
	@GetMapping("/hello-int")
	public String getMessagesIn18NFormat(@RequestHeader(name="Accept-Language",required=false)String locale) {
		return messageSource.getMessage("label.hello",null, new Locale(locale));
	}
	
	
	@GetMapping("/hello-int2")
	public String getMessagesIn18NFormat() {
		return messageSource.getMessage("label.hello",null, LocaleContextHolder.getLocale());
	}

	
}
