package org.amos.swagger2.springboot.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.amos.swagger2.common.constants.Constants;
import org.amos.swagger2.springboot.http.HttpContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Component
public class I18nUtils {

	@Autowired
	private MessageSource messageSource;
	
	public String getI18nMessage(String code){
		
		try {

			HttpServletRequest httpRequest = HttpContext.getRequest();
			String language = httpRequest.getHeader(Constants.LANGUAGE_HEADER_NAME);
			if(StringUtils.isEmpty(language)){
				
				language = Constants.LANGUAGE_DEFAULT;
			}
			String message = messageSource.getMessage(code, null, new Locale(language));
			
			return message;
		} catch (NoSuchMessageException e) {
			
			return code;
		}
	}
}
