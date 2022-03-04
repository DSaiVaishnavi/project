package com.microservice.user.exception;

public class AadharcardAlreadyExistException extends Exception{

    public AadharcardAlreadyExistException(String message){
        super(message);
    }

    public AadharcardAlreadyExistException(){}

}
