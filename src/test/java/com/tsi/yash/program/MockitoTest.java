package com.tsi.yash.program;

import com.tsi.yash.program.model.Actor;
import com.tsi.yash.program.model.FilmActor;
import com.tsi.yash.program.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;


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

        Actor addActor = new Actor(1,"TestAdd","TestAdd");

        given(actorRepository.findById(addActor.getActor_id())).willReturn(Optional.of(addActor));

        ResponseEntity<Actor> actual = myFirstMicroserviceApplication.getActor(addActor.getActor_id());

        Assertions.assertEquals(ResponseEntity.ok(addActor), actual);
        verify(actorRepository).findById(addActor.getActor_id());

    }

    @Test
    public void testAddActor(){

        Actor newActor = new Actor("TestAdd", "TestAdd");

        String expected = "Saved";

        String actual = myFirstMicroserviceApplication.addActor(newActor.getFirst_name(), newActor.getLast_name());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArgumentCaptor.capture());

        actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual, "Actor is not saved in database");

    }


    @Test
    public void testUpdateActor(){

        Actor updateActor1 = new Actor("TestUpdate", "TestUpdate");

        Actor updateActor2 = new Actor("TestUpdated", "TestUpdated");

        given(actorRepository.findById(updateActor1.getActor_id())).willReturn(Optional.of(updateActor1));

        ResponseEntity<Actor> expected = ResponseEntity.ok(updateActor2);

        ResponseEntity<Actor> actual = myFirstMicroserviceApplication.updateActor(updateActor1.getActor_id(), updateActor2.getFirst_name(), updateActor2.getLast_name());

        Assertions.assertNotEquals(expected, actual, "DB does not update correctly");

    }

    @Test
    public void testDeleteActor(){

        Actor newActor = new Actor("TestAdd", "TestAdd");
        given(actorRepository.findById(newActor.getActor_id())).willReturn(Optional.of(newActor));

        ResponseEntity<HttpStatus> expected = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        ResponseEntity<HttpStatus> actual = myFirstMicroserviceApplication.deleteActor(newActor.getActor_id());

        Assertions.assertEquals(expected, actual, "Actor not correctly deleted from DB");

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

        FilmActor addFilmActor = new FilmActor(1,1);

        given(filmActorRepository.findById(addFilmActor.getActor_id())).willReturn(Optional.of(addFilmActor));

        ResponseEntity<FilmActor> actual = myFirstMicroserviceApplication.getFilmActor(addFilmActor.getActor_id());

        Assertions.assertEquals(ResponseEntity.ok(addFilmActor), actual);
        verify(filmActorRepository).findById(addFilmActor.getActor_id());

    }

    @Test
    public void testAddFilmActor(){

        FilmActor newFilmActor = new FilmActor(1,1);

        String expected = "Saved";

        String actual = myFirstMicroserviceApplication.addFilmActor(newFilmActor.getActor_id(), newFilmActor.getFilm_id());

        ArgumentCaptor<FilmActor> filmActorArgumentCaptor = ArgumentCaptor.forClass(FilmActor.class);

        verify(filmActorRepository).save(filmActorArgumentCaptor.capture());

        filmActorArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual, "Actor is not saved in database");

    }


    @Test
    public void testUpdateFilmActor(){

        FilmActor updateFilmActor1 = new FilmActor(1,1);

        FilmActor updateFilmActor2 = new FilmActor(2,2);

        given(filmActorRepository.findById(updateFilmActor1.getActor_id())).willReturn(Optional.of(updateFilmActor1));

        ResponseEntity<FilmActor> expected = ResponseEntity.ok(updateFilmActor2);

        ResponseEntity<FilmActor> actual = myFirstMicroserviceApplication.updateFilmActor(updateFilmActor1.getActor_id(), updateFilmActor2.getActor_id(), updateFilmActor2.getFilm_id());

        Assertions.assertNotEquals(expected, actual, "DB does not update correctly");

    }

    @Test
    public void testDeleteFilmActor(){

        FilmActor newFilmActor = new FilmActor(1,1);
        given(filmActorRepository.findById(newFilmActor.getActor_id())).willReturn(Optional.of(newFilmActor));

        ResponseEntity<HttpStatus> expected = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        ResponseEntity<HttpStatus> actual = myFirstMicroserviceApplication.deleteFilmActor(newFilmActor.getActor_id());

        Assertions.assertEquals(expected, actual, "Actor not correctly deleted from DB");

    }

     /* *
     *
     * Film crud operation tests
     *
     * */



     /* *
     *
     * FilmCategory crud operation tests
     *
     * */



     /* *
     *
     * Category crud operation tests
     *
     * */



     /* *
     *
     * Language crud operations
     *
     * */

}
