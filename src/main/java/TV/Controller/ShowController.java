package TV.Controller;

import TV.Model.Show;
import TV.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ShowController {

    ShowRepository showRepo;

    @Autowired
    public ShowController(ShowRepository repo)
    { showRepo = repo; }


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String test(){
        return "The TV SHOW API!";
    }

    @RequestMapping(value="/shows", method = RequestMethod.GET)
    public Page<Show> getShows(Pageable pageable){

        return showRepo.findAllByOrderByTitleAsc(pageable);

    }

    @RequestMapping(value="/shows/{id}", method = RequestMethod.GET)
    public ResponseEntity<Show> getShow(@PathVariable Integer id){

        Optional<Show> show = showRepo.findById(id);

        if(show.isPresent()){
            return new ResponseEntity<Show>(show.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/shows", method = RequestMethod.POST)
    public ResponseEntity<Show> createShow(@RequestBody Show show){

        showRepo.save(show);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/shows/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Show> updateShow(@RequestBody Show show, @PathVariable Integer id){

        Optional<Show> showOptional = showRepo.findById(id);

        if(showOptional.isPresent()){
            show.setId(id);
            showRepo.save(show);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
