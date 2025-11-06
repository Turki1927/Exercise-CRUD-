package org.example.ex_crud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTracker {
    private  int ID;
    private  String title;
    private String description;
    private String status;

}
