package main.fudan.CourseSelectionSystem.service;

import main.fudan.CourseSelectionSystem.entity.Request;

public interface RequestService {
    /* request a section */
    public boolean addRequest(Request request);

    /* read a request */
    public boolean readRequest(Request request);
}
