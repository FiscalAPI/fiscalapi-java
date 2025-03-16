package com.fiscalapi.models.invoicing;

// Datos de los sellos del emisor
public class TaxCredential {
    private String base64File;
    private Integer fileType;
    private String password;

    public String getBase64File() {
        return base64File;
    }
    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }
    public Integer getFileType() {
        return fileType;
    }
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}