package com.portifolio.zeroquest.domain.exceptions;

public class EntityResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntityResourceNotFoundException(String msg){
        super(msg);
    }

}
