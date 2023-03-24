package com.Services;

import java.util.List;

import com.Entities.Sprint;
import com.Entities.Task;

public interface TaskServices {
	
    public Sprint createSprint(Sprint sprint);
    
    public Task addTaskToSprint(Integer sprintId, Task task);
    
    public Task changeTaskAssignee(Integer taskId, String newAssignee);
    
    public Task changeTaskStatus(Integer taskId, String newStatus);
    
    public List<Task> getTasksBySprint(Integer sprintId);
    
    public List<Task> getTasksByAssignee(String assignee);
}
