package App.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

/*
we're using Lombok and Spring ORM for this.
Lombok introduces annotations like noargsconstructor, data, allargsconstructor, which automatically generate parts of
a model class like constructor/getter setter. Lombok is NOT part of spring. it's just a nice convenience library.

Spring ORM : Object relational mapping. Introduces annotations like entity, id, column, onetomany, etc
ORM maps POJO (plain old java object) to database rows automatically.
 */
@Data //LOMBOK: introduces automatic getters/setters
@AllArgsConstructor //LOMBOK: automatic constructor
@NoArgsConstructor //LOMBOK: automatic constructor
@ToString //LOMBOK
@EqualsAndHashCode //LOMBOK
@Entity //SPRING ORM: registers this class to be associated with a database table. All fields are automatically made into columns.
public class Movie {
    @Id //SPRING ORM: primary key
    @Column //SPRING ORM: (doesnt do anything since we have @entity) registers this field as a column in our table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SPRING ORM: automatically generate new values.
    int id;
    @Column
    String title;
    @Column
    int year;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="director_id")
    Director director;
}