package App.Repository;

import App.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

//JPARepository
//inside <> : class used as model , type used as primary key
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    /*
    but how do we write queries that spring can't automatically generate for us?
    JPQL:
    JPQL will parse to/from objects directly
     */
    @Query("FROM Director")
    public List<Director> getAllDirectors();
}