package cn.itsource.pethome.org.config;

import cn.itsource.pethome.org.util.AjaxResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义全局异常
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public AjaxResult catchException(Throwable t, HttpServletRequest request){
        return new AjaxResult(false,t.toString(),null);
    }

    private Integer getStatus(HttpServletRequest request) {
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(code==null){
            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        return  code;
    }
}
