package com.tsi.yash.program;

import com.tsi.yash.program.model.*;
import com.tsi.yash.program.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;


    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmActorRepository, filmRepository,filmCategoryRepository, categoryRepository, languageRepository);
    }

     /* *
     *
     * Actor crud operation tests
     *
     * */

    @Test
    public void getAllActors(){

        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();

    }

    @Test
    public void getActor(){

        Actor testActor = new Actor(1,"TestAdd","TestAdd");

        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));

        ResponseEntity<Actor> actual = myFirstMicroserviceApplication.getActor(testActor.getActor_id());

        Assertions.assertEquals(ResponseEntity.ok(testActor), actual, "Actor is not retrieved from database correctly");

    }

    @Test
    public void testAddActor(){

        Actor testActor = new Actor("TestAdd", "TestAdd");

        ResponseEntity<Actor> actual = myFirstMicroserviceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArgumentCaptor.capture());

        ResponseEntity<Actor> expected = ResponseEntity.ok(actorArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "Actor is not saved in database");

    }


    @Test
    public void testUpdateActor(){

        Actor testActor1 = new Actor(1,"TestUpdate", "TestUpdate");

        Actor testActor2 = new Actor(1,"TestUpdated", "TestUpdated");

        when(actorRepository.findById(testActor1.getActor_id())).thenReturn(Optional.of(testActor2));

        ResponseEntity<Actor> actual = myFirstMicroserviceApplication.updateActor(testActor1.getActor_id(), testActor2.getFirst_name(), testActor2.getLast_name());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArgumentCaptor.capture());

        ResponseEntity<Actor> expected = ResponseEntity.ok(actorArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "Actor is not updated successfully");

    }

    @Test
    public void testDeleteActor(){

        Actor testActor = new Actor(1 ,"TestAdd", "TestAdd");

        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        myFirstMicroserviceApplication.deleteActor(1);
        verify(actorRepository).delete(testActor);
    }


     /* *
     *
     * FilmActor crud operation tests
     *
     * */

    @Test
    public void getAllFilmActors(){

        myFirstMicroserviceApplication.getAllFilmActors();
        verify(filmActorRepository).findAll();

    }

    @Test
    public void getFilmActor(){

        FilmActor testFilmActor = new FilmActor(1,1);

        when(filmActorRepository.findById(1)).thenReturn(Optional.of(testFilmActor));

        ResponseEntity<FilmActor> actual = myFirstMicroserviceApplication.getFilmActor(testFilmActor.getActor_id());

        Assertions.assertEquals(ResponseEntity.ok(testFilmActor), actual, "FilmActor is not retrieved from database correctly");

    }

    @Test
    public void testAddFilmActor(){

        FilmActor testFilmActor = new FilmActor(1,1);

        ResponseEntity<FilmActor> actual = myFirstMicroserviceApplication.addFilmActor(testFilmActor.getActor_id(), testFilmActor.getFilm_id());

        ArgumentCaptor<FilmActor> filmActorArgumentCaptor = ArgumentCaptor.forClass(FilmActor.class);

        verify(filmActorRepository).save(filmActorArgumentCaptor.capture());

        ResponseEntity<FilmActor> expected = ResponseEntity.ok(filmActorArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "FilmActor is not saved in database");

    }


    @Test
    public void testUpdateFilmActor(){

        FilmActor testFilmActor1 = new FilmActor(1,1);

        FilmActor testFilmActor2 = new FilmActor(1,2);

        when(filmActorRepository.findById(testFilmActor1.getActor_id())).thenReturn(Optional.of(testFilmActor2));

        ResponseEntity<FilmActor> actual = myFirstMicroserviceApplication.updateFilmActor(testFilmActor1.getActor_id(), testFilmActor2.getActor_id(), testFilmActor2.getFilm_id());

        ArgumentCaptor<FilmActor> filmActorArgumentCaptor = ArgumentCaptor.forClass(FilmActor.class);

        verify(filmActorRepository).save(filmActorArgumentCaptor.capture());

        ResponseEntity<FilmActor> expected = ResponseEntity.ok(filmActorArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "FilmActor is not updated successfully");

    }

    @Test
    public void testDeleteFilmActor(){

        FilmActor testFilmActor = new FilmActor(1 ,1);

        when(filmActorRepository.findById(1)).thenReturn(Optional.of(testFilmActor));
        myFirstMicroserviceApplication.deleteFilmActor(1);
        verify(filmActorRepository).delete(testFilmActor);

    }

     /* *
     *
     * Film crud operation tests
     *
     * */

    @Test
    public void getAllFilms(){

        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();

    }

    @Test
    public void getFilm(){

        Film testFilm = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");


        when(filmRepository.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testFilm));

        ResponseEntity<Film> actual = myFirstMicroserviceApplication.getFilm(testFilm.getFilm_id());

        Assertions.assertEquals(ResponseEntity.ok(testFilm), actual, "Film is not retrieved from database correctly");

    }

    @Test
    public void testAddFilm(){

        Film testFilm = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

        ResponseEntity<Film> actual = myFirstMicroserviceApplication.addFilm(testFilm.getTitle(), testFilm.getDescription(),testFilm.getRelease_year(),testFilm.getLanguage_id(), testFilm.getOriginal_language_id(), testFilm.getRental_duration(), testFilm.getRental_rate(), testFilm.getLength(), testFilm.getReplacement_cost(), testFilm.getRating(), testFilm.getSpecial_features());

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);

        verify(filmRepository).save(filmArgumentCaptor.capture());

        ResponseEntity<Film> expected = ResponseEntity.ok(filmArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "Film is not saved in database");

    }


    @Test
    public void testUpdateFilm(){

        Film testFilm1 = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

        Film testFilm2 = new Film("title 2", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

        when(filmRepository.findById(testFilm1.getFilm_id())).thenReturn(Optional.of(testFilm2));

        ResponseEntity<Film> actual = myFirstMicroserviceApplication.updateFilm(testFilm1.getFilm_id(), testFilm2.getTitle(), testFilm2.getDescription(),testFilm2.getRelease_year(),testFilm2.getLanguage_id(), testFilm2.getOriginal_language_id(), testFilm2.getRental_duration(), testFilm2.getRental_rate(), testFilm2.getLength(), testFilm2.getReplacement_cost(), testFilm2.getRating(), testFilm2.getSpecial_features());

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);

        verify(filmRepository).save(filmArgumentCaptor.capture());

        ResponseEntity<Film> expected = ResponseEntity.ok(filmArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "Film is not updated successfully");

    }

    @Test
    public void testDeleteFilm(){

        Film testFilm = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));
        myFirstMicroserviceApplication.deleteFilm(1);
        verify(filmRepository).delete(testFilm);

    }


     /* *
     *
     * FilmCategory crud operation tests
     *
     * */



    @Test
    public void getAllFilmCategory(){

        myFirstMicroserviceApplication.getAllFilmCategory();
        verify(filmCategoryRepository).findAll();

    }

    @Test
    public void getFilmCategory(){

        FilmCategory testFilmCategory = new FilmCategory(1,1);

        when(filmCategoryRepository.findById(1)).thenReturn(Optional.of(testFilmCategory));

        ResponseEntity<FilmCategory> actual = myFirstMicroserviceApplication.getFilmCategory(testFilmCategory.getFilm_id());

        Assertions.assertEquals(ResponseEntity.ok(testFilmCategory), actual, "FilmCategory is not retrieved from database correctly");

    }

    @Test
    public void testAddFilmCategory(){

        FilmCategory testFilmCategory = new FilmCategory(1,1);

        ResponseEntity<FilmCategory> actual = myFirstMicroserviceApplication.addFilmCategory(testFilmCategory.getFilm_id(), testFilmCategory.getCategory_id());

        ArgumentCaptor<FilmCategory> filmCategoryArgumentCaptor = ArgumentCaptor.forClass(FilmCategory.class);

        verify(filmCategoryRepository).save(filmCategoryArgumentCaptor.capture());

        ResponseEntity<FilmCategory> expected = ResponseEntity.ok(filmCategoryArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "FilmCategory is not saved in database");

    }


    @Test
    public void testUpdateFilmCategory(){

        FilmCategory testFilmCategory1 = new FilmCategory(1,1);

        FilmCategory testFilmCategory2 = new FilmCategory(1,2);

        when(filmCategoryRepository.findById(testFilmCategory1.getFilm_id())).thenReturn(Optional.of(testFilmCategory2));

        ResponseEntity<FilmCategory> actual = myFirstMicroserviceApplication.updateFilmCategory(testFilmCategory2.getFilm_id(), testFilmCategory2.getCategory_id());

        ArgumentCaptor<FilmCategory> filmCategoryArgumentCaptor = ArgumentCaptor.forClass(FilmCategory.class);

        verify(filmCategoryRepository).save(filmCategoryArgumentCaptor.capture());

        ResponseEntity<FilmCategory> expected = ResponseEntity.ok(filmCategoryArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "FilmCategory is not updated successfully");

    }

    @Test
    public void testDeleteFilmCategory(){

        FilmCategory testFilmCategory = new FilmCategory(1 ,1);

        when(filmCategoryRepository.findById(1)).thenReturn(Optional.of(testFilmCategory));
        myFirstMicroserviceApplication.deleteFilmCategory(1);
        verify(filmCategoryRepository).delete(testFilmCategory);

    }


     /* *
     *
     * Category crud operation tests
     *
     * */

    @Test
    public void getAllCategory(){

        myFirstMicroserviceApplication.getAllCategory();
        verify(categoryRepository).findAll();

    }

    @Test
    public void getCategory(){

        Category testCategory = new Category("Test category");

        when(categoryRepository.findById(testCategory.getCategory_id())).thenReturn(Optional.of(testCategory));

        ResponseEntity<Category> actual = myFirstMicroserviceApplication.getCategory(testCategory.getCategory_id());

        Assertions.assertEquals(ResponseEntity.ok(testCategory), actual, "Category is not retrieved from database correctly");

    }

    @Test
    public void testAddCategory(){

        Category testCategory = new Category("Test category");

        ResponseEntity<Category> actual = myFirstMicroserviceApplication.addCategory(testCategory.getName());

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);

        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        ResponseEntity<Category> expected = ResponseEntity.ok(categoryArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "Category is not saved in database");

    }


    @Test
    public void testUpdateCategory(){

        Category testCategory1 = new Category("TestUpdate");

        Category testCategory2 = new Category("TestUpdated");

        when(categoryRepository.findById(testCategory1.getCategory_id())).thenReturn(Optional.of(testCategory2));

        ResponseEntity<Category> actual = myFirstMicroserviceApplication.updateCategory(testCategory1.getCategory_id(), testCategory2.getName());

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);

        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        ResponseEntity<Category> expected = ResponseEntity.ok(categoryArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "Actor is not updated successfully");

    }

    @Test
    public void testDeleteCategory(){

        Category testCategory = new Category("Testdelete");

        when(categoryRepository.findById(testCategory.getCategory_id())).thenReturn(Optional.of(testCategory));
        myFirstMicroserviceApplication.deleteCategory(testCategory.getCategory_id());
        verify(categoryRepository).delete(testCategory);
    }



    /* *
     *
     * Language crud operations
     *
     * */


    @Test
    public void getAllLanguage(){

        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();

    }

    @Test
    public void getLanguage(){

        Language testLanguage = new Language("Test category");

        when(languageRepository.findById(testLanguage.getLanguage_id())).thenReturn(Optional.of(testLanguage));

        ResponseEntity<Language> actual = myFirstMicroserviceApplication.getLanguage(testLanguage.getLanguage_id());

        Assertions.assertEquals(ResponseEntity.ok(testLanguage), actual, "Category is not retrieved from database correctly");

    }

    @Test
    public void testAddLanguage(){

        Language testLanguage = new Language("Test category");

        ResponseEntity<Language> actual = myFirstMicroserviceApplication.addLanguage(testLanguage.getName());

        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);

        verify(languageRepository).save(languageArgumentCaptor.capture());

        ResponseEntity<Language> expected = ResponseEntity.ok(languageArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "Category is not saved in database");

    }


    @Test
    public void testUpdateLanguage(){

        Language testLanguage1 = new Language("TestUpdate");

        Language testLanguage2 = new Language("TestUpdated");

        when(languageRepository.findById(testLanguage1.getLanguage_id())).thenReturn(Optional.of(testLanguage2));

        ResponseEntity<Language> actual = myFirstMicroserviceApplication.updateLanguage(testLanguage1.getLanguage_id(), testLanguage2.getName());

        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);

        verify(languageRepository).save(languageArgumentCaptor.capture());

        ResponseEntity<Language> expected = ResponseEntity.ok(languageArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "Actor is not updated successfully");

    }

    @Test
    public void testDeleteLanguage(){

        Language testLanguage = new Language("Test delete");

        when(languageRepository.findById(testLanguage.getLanguage_id())).thenReturn(Optional.of(testLanguage));
        myFirstMicroserviceApplication.deleteLanguage(testLanguage.getLanguage_id());
        verify(languageRepository).delete(testLanguage);
    }


}
