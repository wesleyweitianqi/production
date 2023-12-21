package com.rex.productionserver.exception;

import com.rex.productionserver.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class GlobalException {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("Operation failed due to data-related issue");
        }
        return null;
    }
}
