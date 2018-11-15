package org.amos.swagger2.common.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amos.framework.exception.BusinessException;
import org.amos.framework.exception.ParamsException;
import org.amos.framework.exception.SecurityException;
import org.amos.framework.exception.SessionTimeOutException;
import org.amos.framework.exception.Success;
import org.amos.framework.exception.SystemException;
import org.amos.framework.exception.UnauthorizedException;
import org.amos.framework.exception.bean.ErrorCode;
import org.amos.framework.response.GlobalResultResponse;
import org.amos.framework.response.ResultResponse;
import org.amos.swagger2.common.constants.Constants;
import org.amos.swagger2.springboot.i18n.I18nUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@ControllerAdvice
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class GlobalExceptionHandler implements ErrorController {

	public Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Value("${server.error.path:${error.path:/error}}")
    private static String errorPath = Constants.SYSTEM_EXCEPTION;
	
	private static final String ERROR_ATTRIBUTE = DefaultErrorAttributes.class.getName()
			+ ".ERROR";
	
	@RequestMapping
    public void error(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		Throwable error = getError(requestAttributes);
		
		response.setStatus(HttpStatus.OK.value());
		
		Integer status = getAttribute(requestAttributes,"javax.servlet.error.status_code");
		LOGGER.error("Error status is {}",status);
		
		if(null == error){
			
			throw new Exception("Error status is "+ status +"");
		}
		
		throw error;
    }

	public Throwable getError(RequestAttributes requestAttributes) {
		Throwable exception = getAttribute(requestAttributes, ERROR_ATTRIBUTE);
		if (exception == null) {
			exception = getAttribute(requestAttributes, "javax.servlet.error.exception");
		}
		return exception;
	}

	@SuppressWarnings("unchecked")
	private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
		return (T) requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
	}

	@Override
	public String getErrorPath() {	
		
		return errorPath;
	}
	
	@Autowired
	private I18nUtils i18nUtils;
	
	/**
	 * 会话失效
	 * 重定向地址
	 */
	protected String redirectUrl = "/";
	
	/**
	 * 异常编码前缀
	 */
	protected String errorCodePrefix = "";
	
	/**
	 * 拦截全局异常
	 * Throwable是所有异常的最终父级
	 * @param ex 异常
	 * @param request 请求信息
	 * @param response 响应信息
	 * @return 全局响应格式
	 */
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResultResponse<?> processThrowableException(Throwable ex, HttpServletRequest request, HttpServletResponse response){

		String errorCode = ErrorCode.ERR_SYSTEM_EXCEPTION.getCode();
		String errorMssage = ErrorCode.ERR_SYSTEM_EXCEPTION.getMsg();

		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		
		this.processCustomException(ex, result);
		
		return result;
	}
	
	/**
	 * 报文校验异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(ParamsException.class)
	@ResponseBody
	public ResultResponse<?> processParamsException(ParamsException ex){
		
		String errorCode = ex.getErrorCode();
		String errorMssage = ex.getErrormessage();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 报文校验异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(Success.class)
	@ResponseBody
	public ResultResponse<?> processSuccess(Success success){
		
		String code = success.getCode();
		String mssage = success.getMessage();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, code, i18nUtils.getI18nMessage(mssage));
		return result;
	}
	
	/**
	 * 报文为空异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResultResponse<?> processHttpMessageNotReadableException(HttpMessageNotReadableException ex){
		
		String errorCode = ErrorCode.ERR_PARAMS_IS_NOT_EMPTY.getCode();
		String errorMssage = ErrorCode.ERR_PARAMS_IS_NOT_EMPTY.getMsg();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		
		return result;
	}
	
	/**
	 * 业务异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public ResultResponse<?> processBusinessException(BusinessException ex){
		
		String errorCode = ex.getErrorCode();
		String errorMssage = ex.getErrormessage();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 授权异常
	 * @param ex 授权异常
	 * @return
	 */
	@ExceptionHandler(SecurityException.class)
	@ResponseBody
	public ResultResponse<?> processSecurityException(SecurityException ex){
		
		String errorCode = ex.getErrorCode();
		String errorMssage = ex.getErrormessage();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 系统异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(SystemException.class)
	@ResponseBody
	public ResultResponse<?> processSystemException(SystemException ex){
		
		String errorCode = ErrorCode.ERR_SYSTEM_EXCEPTION.getCode();
		String errorMssage = ErrorCode.ERR_SYSTEM_EXCEPTION.getMsg();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 系统异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseBody
	public ResultResponse<?> processSystemException(AccessDeniedException ex){
		
		String errorCode = ErrorCode.ERR_UNAUTHORIZED.getCode();
		String errorMssage = ErrorCode.ERR_UNAUTHORIZED.getMsg();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 会话超时异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(SessionTimeOutException.class)
	@ResponseBody
	public ResultResponse<?> processSessionTimeOutException(SessionTimeOutException ex,HttpServletRequest request, HttpServletResponse response){
		
		String errorCode = ErrorCode.ERR_SYSTEM_EXCEPTION.getCode();
		String errorMssage = ErrorCode.ERR_SYSTEM_EXCEPTION.getMsg();
		try {
			
			if(this.isAjax(request)){

				errorCode = ErrorCode.ERR_SESSION_TIME_OUT.getCode();
				errorMssage = ErrorCode.ERR_SESSION_TIME_OUT.getMsg();
			}else{

	            response.sendRedirect(redirectUrl);
	            
	            return null;
			}
		} catch (IOException e) {

			LOGGER.error("Global default exception write index page failed,exception is {}",e);
		}
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 未经授权异常
	 * @param ex 异常信息
	 * @return
	 */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public ResultResponse<?> processUnauthorizedException(UnauthorizedException ex){
		
		String errorCode = ErrorCode.ERR_UNAUTHORIZED.getCode();
		String errorMssage = ErrorCode.ERR_UNAUTHORIZED.getMsg();
		
		ResultResponse<?> result = GlobalResultResponse.getJsonResult(null, errorCode, i18nUtils.getI18nMessage(errorMssage));
		return result;
	}
	
	/**
	 * 自定义异常转换
	 * 兼容各个项目不同的异常类型
	 * @param errorCode 异常编码
	 * @param errorMssage 异常信息
	 * @return 
	 */
	protected <T> void processCustomException(Throwable ex, ResultResponse<T> result){

		LOGGER.error("Global exception handler exception is {}",ex);
	}
	
	/**
	 * 判断是否是ajax请求
	 * @param request
	 * @return
	 */
	private Boolean isAjax(HttpServletRequest request){
		
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equals(requestType)){
		    
			return true;
		}else{
		   
			return false;
		}
	}

	public String getErrorCodePrefix() {
		return errorCodePrefix;
	}

	public void setErrorCodePrefix(String errorCodePrefix) {
		this.errorCodePrefix = errorCodePrefix;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
}
