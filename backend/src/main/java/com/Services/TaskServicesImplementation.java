package com.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entities.Sprint;
import com.Entities.Task;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task addTaskToSprint(Integer sprintId, Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task changeTaskAssignee(Integer taskId, String newAssignee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task changeTaskStatus(Integer taskId, String newStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksBySprint(Integer sprintId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksByAssignee(String assignee) {
		// TODO Auto-generated method stub
		return null;
	}

}
