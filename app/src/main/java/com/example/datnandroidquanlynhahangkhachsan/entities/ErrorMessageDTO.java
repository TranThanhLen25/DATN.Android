package com.example.datnandroidquanlynhahangkhachsan.entities;

public class ErrorMessageDTO {
    private Boolean flagSuccess;
    private Boolean flagException;
    private String errorMessage;
    private String errorCode;
    private Object data;
    private Object data2;

    public Boolean getFlagSuccess() {
        return flagSuccess;
    }

    public void setFlagSuccess(Boolean flagSuccess) {
        this.flagSuccess = flagSuccess;
    }

    public Boolean getFlagException() {
        return flagException;
    }

    public void setFlagException(Boolean flagException) {
        this.flagException = flagException;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public ErrorMessageDTO() {
        flagSuccess = false;
        flagException = false;
        errorMessage = "";
        errorCode = "";
        data = null;
    }
}
