
# Task Planner

Backend of a taskplanner where user can add sprints, add tasks to sprint, change status and assignee of a task, get all sprints and its tasks, delete sprints and tasks.


## Run

[Railway Cloud Deployed Link (Click Here)](https://task-planner-production.up.railway.app/swagger-ui/index.html)

OR 

Run locally : Clone this repo > Change MySQL credentials > Run main file > http://localhost:8080/swagger-ui/index.html


## API Reference

#### Add Sprints

```http
  POST /taskplanner/sprints
```


#### Add task to a sprint

```http
  POST /taskplanner/sprints/{sprintId}/tasks
```



#### Change status of a task

```http
  PUT /taskplanner/tasks/{taskId}/status
```

#### Change assignee of a task

```http
  PUT /taskplanner/tasks/{taskId}/assignee
```

#### Get list of all sprints

```http
  GET /taskplanner/sprints
```

####  Get all tasks assigned to a assignee

```http
  GET /taskplanner/tasks/assignee
```

#### Get all tasks of a sprint

```http
  GET /taskplanner/sprints/{sprintId}/tasks
```

#### Delete any task

```http
  DELETE /taskplanner/tasks/{taskId}
```

#### Delete any sprint

```http
  DELETE /taskplanner/sprints/{sprintId}
```

