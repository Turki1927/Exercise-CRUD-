package org.example.ex_crud.Controller;

import org.example.ex_crud.Api.ApiResponse;
import org.example.ex_crud.Model.TaskTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task-tracker")
public class TaskTrackerController {

    ArrayList <TaskTracker> tasks = new ArrayList<>();

@GetMapping("/get")
    public ArrayList<TaskTracker> getTask(){
        return tasks;
    }

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody TaskTracker task){
    tasks.add(task);
    return new ApiResponse("task is added");
    }

    @PutMapping("/update/{index}")
public ApiResponse updateTask( @PathVariable int index, @RequestBody TaskTracker task){
    tasks.set(index,task);
    return  new ApiResponse("task is updated");
}

@DeleteMapping("/dealate/{index}")
public  ApiResponse dealateTask(@PathVariable int index){
    tasks.remove(index);
    return  new ApiResponse("task is dealated");
}

    @PutMapping("/changeStatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        TaskTracker task = tasks.get(index);
        if (task.getStatus().equalsIgnoreCase("done")){
            task.setStatus("not done");
        }else{
            task.setStatus("done");
        }
        return new ApiResponse("Task status has been changed ");
    }




@GetMapping("/search/{title}")
    public ApiResponse searchTask (@PathVariable String title)
    {
        for (TaskTracker task :tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                return new ApiResponse("task is found: "+ task);

            }
        }
        return new ApiResponse("task are not found");
    }




}
