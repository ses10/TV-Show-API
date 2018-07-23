package TV.Repository;

import TV.Model.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show, Integer> {

    List<Show> findAllByOrderByTitleAsc();
    Page<Show> findAllByOrderByTitleAsc(Pageable pageable);
}
