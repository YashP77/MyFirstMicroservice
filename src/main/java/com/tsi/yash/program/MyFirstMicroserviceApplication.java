package com.tsi.yash.program;

import com.tsi.yash.program.exception.ResourceNotFoundException;
import com.tsi.yash.program.model.Actor;
import com.tsi.yash.program.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;

	private String saved = "Saved";

	public static void main(String[] args) {

		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/getActor")
	public ResponseEntity<Actor> getActor(@RequestParam Integer id){
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " + id));
		return ResponseEntity.ok(actor);
	}

	@PostMapping("/addActor")
	public @ResponseBody String addActor(@RequestParam String first_name, String last_name){


		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);

		return saved;
	}

	@PutMapping("/updateActor")
	public ResponseEntity<Actor> updateActor(@RequestParam Integer id, String firstName, String lastName){
		Actor updateActor = actorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + id));

		updateActor.setFirst_name(firstName);
		updateActor.setLast_name(lastName);
		updateActor.setLastUpdate(LocalDateTime.now());

		actorRepository.save(updateActor);

		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/deleteActor")
	public ResponseEntity<HttpStatus> deleteActor(@RequestParam Integer id){

		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + id));

		actorRepository.delete(actor);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
