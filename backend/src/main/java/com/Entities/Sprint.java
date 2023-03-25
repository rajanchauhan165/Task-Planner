package com.Entities;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sprint {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sprintId;
    
    private String name;
    
    
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    
    
    //getters and setters below this line
    public Integer getSprintId() {
		return sprintId;
	}

	public void setSprintId(Integer sprintId) {
		this.sprintId = sprintId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
    //getters and setters above this line
}
