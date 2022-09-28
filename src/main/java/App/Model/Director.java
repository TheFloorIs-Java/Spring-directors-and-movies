package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;



@Data //LOMBOK: introduces automatic getters/setters
@AllArgsConstructor //LOMBOK: automatic constructor
@NoArgsConstructor //LOMBOK: automatic constructor
@ToString //LOMBOK
@EqualsAndHashCode //LOMBOK
@Entity
//SPRING ORM: registers this class to be associated with a database table. All fields are automatically made into columns.
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SPRING ORM: automatically generate new values.
    @Column
    int id;
    @Column
    String name;
    @OneToMany(mappedBy = "director")
    @JsonManagedReference
    List<Movie> movies;
}