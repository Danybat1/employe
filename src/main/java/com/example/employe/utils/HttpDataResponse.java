package com.example.employe.utils;

public class HttpDataResponse
{
    private String status;
    private String error;
    private Object response;
    
    public HttpDataResponse() {
        this.status = "Successful";
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getError() {
        return this.error;
    }
    
    public void setError(final String error) {
        this.error = error;
    }
    
    public Object getResponse() {
        return this.response;
    }
    
    public void setResponse(final Object response) {
        this.response = response;
    }
}
