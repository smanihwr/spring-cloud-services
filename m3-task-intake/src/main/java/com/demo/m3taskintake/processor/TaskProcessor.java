package com.demo.m3taskintake.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {

    @Autowired
    private Source source;

    public void publishRequest(String payload) {

        //maven://[groupid]:[artifactid]:jar:[version]
        String url = "maven://com.demo:m3-task:jar:0.0.1-SNAPSHOT";

        List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));

        TaskLaunchRequest request = new TaskLaunchRequest(url, input, null, null,
                null);

        System.out.println("create task request");

        GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);

        this.source.output().send(message);
    }
}
