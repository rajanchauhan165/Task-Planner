package com.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Entities.Sprint;
import com.Entities.Task;
import com.Exceptions.SprintException;
import com.Exceptions.TaskException;
import com.Services.TaskServices;

@RestController
@RequestMapping("/taskplanner")
public class TaskPlannerController {
	
	@Autowired
	private TaskServices taskServices;
	
	//create a new sprint
	@PostMapping("/sprints")
	public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint){
		return new ResponseEntity<Sprint>(taskServices.createSprint(sprint),HttpStatus.OK);
	}
	
	//add a task to a sprint
	@PostMapping("sprints/{sprintId}/tasks")
	public ResponseEntity<Task> addTaskToSprint(@PathVariable Integer sprintId, @RequestBody Task task) throws SprintException{
		return new ResponseEntity<Task>(taskServices.addTaskToSprint(sprintId, task),HttpStatus.OK);
	}
	
	//change assignee of a task
	@PutMapping("/tasks/{taskId}/assignee")
	public ResponseEntity<Task> changeTaskAssignee(@PathVariable Integer taskId,@RequestParam("assignee") String newAssignee ) throws TaskException{
		return new ResponseEntity<Task>(taskServices.changeTaskAssignee(taskId, newAssignee),HttpStatus.OK);
	}
	
	//change status of a task
	@PutMapping("/tasks/{taskId}/status")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable Integer taskId, @RequestParam("status") String newStatus) throws TaskException {
        return new ResponseEntity<Task>(taskServices.changeTaskStatus(taskId, newStatus),HttpStatus.OK);
    }
	
	//get all Tasks of a particular Sprint
    @GetMapping("/sprints/{sprintId}/tasks")
    public ResponseEntity<List<Task>> getTasksBySprint(@PathVariable Integer sprintId) throws SprintException {
        return new ResponseEntity<List<Task>>(taskServices.getTasksBySprint(sprintId),HttpStatus.OK);
    }
    
    //get all Tasks assigned to a particular user
    @GetMapping("/tasks/assignee")
    public ResponseEntity<List<Task>> getTasksByAssignee(@RequestParam("assignee") String assignee) {
        return new ResponseEntity<List<Task>>(taskServices.getTasksByAssignee(assignee),HttpStatus.OK);
    }
    
    //delete task
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) throws TaskException{
    	return new ResponseEntity<String>(taskServices.deleteTask(taskId),HttpStatus.OK);
    }
    
  //delete sprint
    @DeleteMapping("/sprints/{sprintId}")
    public ResponseEntity<String> deleteSprint(@PathVariable Integer sprintId) throws SprintException{
    	return new ResponseEntity<String>( taskServices.deleteSprint(sprintId),HttpStatus.OK);
    }
    
    @GetMapping("/sprints")
    public ResponseEntity<List<Sprint>> getAllSprint(){
    	return new ResponseEntity<List<Sprint>>(taskServices.getAllSprints(),HttpStatus.OK);
    }
}
