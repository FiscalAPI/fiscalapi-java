package com.fiscalapi.models.invoicing;

/**
 * Modelo de respuesta de archivos en la api.
 */
public class FileResponse {
    private String base64File;
    private String fileName;
    private String fileExtension;

    public String getBase64File() {
        return base64File;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}