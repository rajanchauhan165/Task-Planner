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
import jakarta.validation.constraints.NotNull;

@Entity
public class Sprint {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sprintId;
    
    @NotNull(message = "Sprint name cannot be null")
	private String name;
    
    
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    
    
    public Sprint(Integer sprintId, String name, List<Task> tasks) {
		this.sprintId = sprintId;
		this.name = name;
		this.tasks = tasks;
	}

	public Sprint() {
	}

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

	@Override
	public String toString() {
		return "Sprint [sprintId=" + sprintId + ", name=" + name + ", tasks=" + tasks + "]";
	}
	
	
}
