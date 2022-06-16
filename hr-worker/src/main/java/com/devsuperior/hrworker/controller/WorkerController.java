package com.devsuperior.hrworker.controller;

import com.devsuperior.hrworker.models.Worker;
import com.devsuperior.hrworker.repository.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerController {
    @Value("${test.config}")
    private String urlTest;

    private WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<String> getConfig(){
        return ResponseEntity.ok(urlTest);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        Optional<Worker> optionalWorker = workerRepository.findById(id);

        return optionalWorker.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }
}
