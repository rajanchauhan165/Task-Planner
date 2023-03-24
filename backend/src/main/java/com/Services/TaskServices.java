package com.Services;

import java.util.List;

import com.Entities.Sprint;
import com.Entities.Task;
import com.Exceptions.SprintException;
import com.Exceptions.TaskException;

public interface TaskServices {
	
    public Sprint createSprint(Sprint sprint);
    
    public Task addTaskToSprint(Integer sprintId, Task task)throws SprintException;
    
    public Task changeTaskAssignee(Integer taskId, String newAssignee)throws TaskException;
    
    public Task changeTaskStatus(Integer taskId, String newStatus)throws TaskException;
    
    public List<Task> getTasksBySprint(Integer sprintId)throws SprintException;
    
    public List<Task> getTasksByAssignee(String assignee);
    
    public String deleteTask(Integer taskId)throws TaskException;
    
    public String deleteSprint(Integer sprintId)throws SprintException;
}
