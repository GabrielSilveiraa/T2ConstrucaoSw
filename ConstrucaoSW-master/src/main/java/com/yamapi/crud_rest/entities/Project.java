package com.yamapi.crud_rest.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {

    @Id
    private String projectName;
    private int numberMembers;
    private String description;
    private String dueDate;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getNumberMembers() {
        return numberMembers;
    }

    public void setNumberMembers(int numberMembers) {
        this.numberMembers = numberMembers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Project{" + "projectdescription='" + projectName + '\'' + ", numberMembers='" + numberMembers + '\'' + ", description='" + description + '\''
                + ", dueDate='" + dueDate + '\'' + '}';
    }
}