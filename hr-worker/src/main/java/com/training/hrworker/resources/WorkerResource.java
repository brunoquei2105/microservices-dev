package com.training.hrworker.resources;

import com.training.hrworker.entities.Worker;
import com.training.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Value("${test.config}")
    private String urlTest;

    private Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    private WorkerRepository workerRepository;

    public WorkerResource(WorkerRepository workerRepository){
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
