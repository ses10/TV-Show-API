package TV.Controller;

import TV.Model.Show;
import TV.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {

    ShowRepository showRepo;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String test(){
        return "The TV SHOW API!";
    }



    @RequestMapping(value="/shows", method = RequestMethod.GET)
    public List<Show> getShows(){
        return (List)showRepo.findAll();
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
    public Show createShow(){
        return null;
    }

    @RequestMapping(value="/shows/{id}", method = RequestMethod.PUT)
    public Show updateShow(@PathVariable Integer id){
        return null;
    }



    @Autowired
    public void setShowRepo(ShowRepository repo)
    { showRepo = repo; }
}
