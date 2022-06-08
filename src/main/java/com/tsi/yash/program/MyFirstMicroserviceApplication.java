package com.tsi.yash.program;

import com.tsi.yash.program.exception.ResourceNotFoundException;
import com.tsi.yash.program.model.*;
import com.tsi.yash.program.repositories.*;
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
	@Autowired
	private FilmActorRepository filmActorRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private LanguageRepository languageRepository;

	private String saved = "Saved";

	public static void main(String[] args) {

		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmActorRepository filmActorRepository, FilmRepository filmRepository, FilmCategoryRepository filmCategoryRepository,CategoryRepository categoryRepository, LanguageRepository languageRepository){

		this.actorRepository = actorRepository;
		this.filmActorRepository = filmActorRepository;
		this.filmRepository = filmRepository;
		this.filmCategoryRepository = filmCategoryRepository;
		this.categoryRepository = categoryRepository;
		this.languageRepository = languageRepository;
	}



	/*
	*
	* Actor crud operations
	*
	* */

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

	 /* *
	 *
	 * FilmActor crud operations
	 *
	 * */

	@GetMapping("/allFilmActors")
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActors(){
		return filmActorRepository.findAll();
	}

	@GetMapping("/getFilmActor")
	public ResponseEntity<FilmActor> getFilmActor(@RequestParam Integer actor_id){
		FilmActor filmActor = filmActorRepository.findById(actor_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " + actor_id));
		return ResponseEntity.ok(filmActor);
	}

	@PostMapping("/addFilmActor")
	public @ResponseBody String addFilmActor(@RequestParam Integer actor_id, Integer film_id){

		FilmActor addFilmActor = new FilmActor(actor_id,film_id);
		filmActorRepository.save(addFilmActor);

		return saved;
	}

	@PutMapping("/updateFilmActor")
	public ResponseEntity<FilmActor> updateFilmActor(@RequestParam Integer id, Integer actor_id, Integer film_id){
		FilmActor updateFilmActor = filmActorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + id));

		updateFilmActor.setActor_id(actor_id);
		updateFilmActor.setFilm_id(film_id);
		updateFilmActor.setLastUpdate(LocalDateTime.now());

		filmActorRepository.save(updateFilmActor);

		return ResponseEntity.ok(updateFilmActor);
	}

	@DeleteMapping("/deleteFilmActor")
	public ResponseEntity<HttpStatus> deleteFilmActor(@RequestParam Integer actor_id){

		FilmActor filmActor = filmActorRepository.findById(actor_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + actor_id));

		filmActorRepository.delete(filmActor);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/* *
	 *
	 * Film crud operations
	 *
	 * */

	@GetMapping("/allFilms")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/getFilm")
	public ResponseEntity<Film> getFilm(@RequestParam Integer film_id){
		Film film = filmRepository.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " + film_id));
		return ResponseEntity.ok(film);
	}

	@PostMapping("/addFilm")
	public @ResponseBody String addFilm(@RequestParam Integer film_id, String title, String description, Integer release_year, String language_id, String original_language_id, Integer rental_duration, Integer rental_rate, Integer length, Integer replacement_cost, Integer rating, String special_features){

		Film addFilm = new Film(film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate,length,replacement_cost,rating,special_features);
		filmRepository.save(addFilm);

		return saved;
	}

	@PutMapping("/updateFilm")
	public ResponseEntity<Film> updateFilm(@RequestParam Integer film_id, String title, String description, Integer release_year, String language_id, String original_language_id, Integer rental_duration, Integer rental_rate, Integer length, Integer replacement_cost, Integer rating, String special_features){
		Film updateFilm = filmRepository.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + film_id));

		updateFilm.setFilm_id(film_id);
		updateFilm.setTitle(title);
		updateFilm.setDescription(description);
		updateFilm.setRelease_year(release_year);
		updateFilm.setLanguage_id(language_id);
		updateFilm.setOriginal_language_id(original_language_id);
		updateFilm.setRental_duration(rental_duration);
		updateFilm.setRental_rate(rental_rate);
		updateFilm.setLength(length);
		updateFilm.setReplacement_cost(replacement_cost);
		updateFilm.setRating(rating);
		updateFilm.setSpecial_features(special_features);
		updateFilm.setLastUpdate(LocalDateTime.now());

		filmRepository.save(updateFilm);

		return ResponseEntity.ok(updateFilm);
	}

	@DeleteMapping("/deleteFilm")
	public ResponseEntity<HttpStatus> deleteFilm(@RequestParam Integer film_id){

		Film film = filmRepository.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + film_id));

		filmRepository.delete(film);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/* *
	 *
	 * FilmCategory crud operations
	 *
	 * */

	@GetMapping("/allFilmCategory")
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategory(){
		return filmCategoryRepository.findAll();
	}

	@GetMapping("/getFilmCategory")
	public ResponseEntity<FilmCategory> getFilmCategory(@RequestParam Integer film_id){
		FilmCategory filmCategory = filmCategoryRepository.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " + film_id));
		return ResponseEntity.ok(filmCategory);
	}

	@PostMapping("/addFilmCategory")
	public @ResponseBody String addFilmCategory(@RequestParam Integer film_id, Integer categoryId){

		FilmCategory addFilmCategory = new FilmCategory(film_id, categoryId);
		filmCategoryRepository.save(addFilmCategory);

		return saved;
	}

	@PutMapping("/updateFilmCategory")
	public ResponseEntity<FilmCategory> updateFilmCategory(@RequestParam Integer film_id, Integer categoryId){
		FilmCategory updateFilmCategory = filmCategoryRepository.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + film_id));

		updateFilmCategory.setFilm_id(film_id);
		updateFilmCategory.setCategory_id(categoryId);
		updateFilmCategory.setLastUpdate(LocalDateTime.now());

		filmCategoryRepository.save(updateFilmCategory);

		return ResponseEntity.ok(updateFilmCategory);
	}

	@DeleteMapping("/deleteFilmCategory")
	public ResponseEntity<HttpStatus> deleteFilmCategory(@RequestParam Integer film_id){

		FilmCategory filmCategory = filmCategoryRepository.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + film_id));

		filmCategoryRepository.delete(filmCategory);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/* *
	 *
	 * Category crud operations
	 *
	 * */

	@GetMapping("/allCategory")
	public @ResponseBody
	Iterable<Category>getAllCategory(){
		return categoryRepository.findAll();
	}

	@GetMapping("/getCategory")
	public ResponseEntity<Category> getCategory(@RequestParam Integer category_id){
		Category category = categoryRepository.findById(category_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " + category_id));
		return ResponseEntity.ok(category);
	}

	@PostMapping("/addCategory")
	public @ResponseBody String addCategory(@RequestParam Integer category_id, String name){

		Category addCategory = new Category(category_id,name);
		categoryRepository.save(addCategory);

		return saved;
	}

	@PutMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestParam Integer categoryId, String name){
		Category updateCategory = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + categoryId));

		updateCategory.setCategory_id(categoryId);
		updateCategory.setName(name);
		updateCategory.setLastUpdate(LocalDateTime.now());

		categoryRepository.save(updateCategory);

		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/deleteCategory")
	public ResponseEntity<HttpStatus> deleteCategory(@RequestParam Integer category_id){

		Category category = categoryRepository.findById(category_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + category_id));

		categoryRepository.delete(category);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/* *
	 *
	 * Language crud operations
	 *
	 * */

	@GetMapping("/allLanguage")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("/getLanguage")
	public ResponseEntity<Language> getLanguage(@RequestParam Integer language_id){
		Language language = languageRepository.findById(language_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " + language_id));
		return ResponseEntity.ok(language);
	}

	@PostMapping("/addLanguage")
	public @ResponseBody String addCategory(@RequestParam String name){

		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);

		return saved;
	}

	@PutMapping("/updateLanguage")
	public ResponseEntity<Language> updateLanguage(@RequestParam Integer language_id, String name){
		Language updateLanguage = languageRepository.findById(language_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + language_id));

		updateLanguage.setLanguage_id(language_id);
		updateLanguage.setName(name);
		updateLanguage.setLastUpdate(LocalDateTime.now());

		languageRepository.save(updateLanguage);

		return ResponseEntity.ok(updateLanguage);
	}

	@DeleteMapping("/deleteLanguage")
	public ResponseEntity<HttpStatus> deleteLanguage(@RequestParam Integer language_id){

		Language language = languageRepository.findById(language_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + language_id));

		languageRepository.delete(language);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}












}
