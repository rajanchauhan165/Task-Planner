package com.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
    private String assignee;
    private String status;
    
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
    
    
    
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
}
