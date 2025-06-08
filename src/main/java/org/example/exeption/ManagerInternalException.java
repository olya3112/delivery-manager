package org.example.exeption;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ManagerInternalException extends RuntimeException implements ManagerException{

    private  Integer code;

    private Object[] args;

    public ManagerInternalException(Integer code, String message){
        super(message);
        this.code = code;
        String[] args = {message};
        this.args = args;
    }



}
