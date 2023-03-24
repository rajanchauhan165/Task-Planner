package com.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entities.Sprint;
import com.Entities.Task;
import com.Exceptions.SprintException;
import com.Exceptions.TaskException;
import com.Repository.SprintRepository;
import com.Repository.TaskRepository;

@Service
public class TaskServicesImplementation implements TaskServices{
	
	@Autowired
	private TaskRepository taskRepo;
	@Autowired
	private SprintRepository sprintRepo;

	@Override
	public Sprint createSprint(Sprint sprint) {
		return sprintRepo.save(sprint);
	}

	@Override
	public Task addTaskToSprint(Integer sprintId, Task task) throws SprintException {
		Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(() -> new SprintException("No Sprint found with id "+sprintId));
        task.setSprint(sprint);
        return taskRepo.save(task);
	}

	@Override
	public Task changeTaskAssignee(Integer taskId, String newAssignee) throws TaskException {
		Task task = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("No Task found with id "+taskId));
        task.setAssignee(newAssignee);
        return taskRepo.save(task);
	}

	@Override
	public Task changeTaskStatus(Integer taskId, String newStatus) throws TaskException {
		Task task = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("No Task found with id "+taskId));
        task.setStatus(newStatus);
        return taskRepo.save(task);
	}

	@Override
	public List<Task> getTasksBySprint(Integer sprintId) throws SprintException {
		Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(() -> new SprintException("No Sprint found with id "+sprintId));
        return sprint.getTasks();
	}

	@Override
	public List<Task> getTasksByAssignee(String assignee) {
		return taskRepo.findByAssignee(assignee);
	}

	@Override
	public String deleteTask(Integer taskId) throws TaskException {
		Optional<Task> task = taskRepo.findById(taskId);
		if(task.isPresent()) {
			taskRepo.delete(task.get());
			return "Task with id "+taskId+" deleted successfully.";
		}
		else {
			throw new TaskException("No Task found with id "+taskId);
		}
	}

	@Override
	public String deleteSprint(Integer sprintId) throws SprintException {
		Optional<Sprint> sprint = sprintRepo.findById(sprintId);
		if(sprint.isPresent()) {
			sprintRepo.delete(sprint.get());
			return "Sprint with id "+sprintId+" deleted successfully.";
		}
		else {
			throw new SprintException("No Sprint found with id "+sprintId);
		}
	}
	
}
