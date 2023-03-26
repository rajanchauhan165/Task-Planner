package com.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@NotNull(message = "Type cannot be null")
    private String type;
	
	@NotNull(message = "Name of task cannot be null")
    private String name;
    private String description;
    
    @NotNull(message = "There must be a assignee for this task")
    private String assignee;
    
    @NotNull(message = "Status cannot be null")
    private String status;
    
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
    
    
    
    public Task(Integer id, String type, String name, String description, String assignee, String status, Sprint sprint) {
	this.id = id;
	this.type = type;
	this.name = name;
	this.description = description;
	this.assignee = assignee;
	this.status = status;
	this.sprint = sprint;
}

	public Task() {
	}

	//getters and setters below this line
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSprint() {
		return sprint.getSprintId();
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
  //getters and setters above this line

	@Override
	public String toString() {
		return "Task [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description + ", assignee="
				+ assignee + ", status=" + status + ", sprint=" + sprint + "]";
	}
	
	
}
