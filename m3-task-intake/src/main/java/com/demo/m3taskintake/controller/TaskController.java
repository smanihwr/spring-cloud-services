package com.demo.m3taskintake.controller;

import com.demo.m3taskintake.processor.TaskProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskProcessor t;

    @PostMapping("tasks")
    public ResponseEntity<String> launchTask(@RequestBody String s) {
        t.publishRequest(s);
        System.out.println("Request made");
        return ResponseEntity.ok("success");
    }

}
