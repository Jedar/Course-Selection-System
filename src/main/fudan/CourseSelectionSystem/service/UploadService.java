package main.fudan.CourseSelectionSystem.service;

import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;

public interface UploadService {
    public String handleUploadFile(HttpServletRequest request);
}
