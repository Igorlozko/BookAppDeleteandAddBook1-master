package ie.atu.bookappmoremicroservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private ObjectId id;
    private String bookId;
    private String title;
    private String author;
    private String releaseDate;
    private String reviewLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;


  //  @DocumentReference // will store ids of the review
   // private List<Review> reviewIds;
}
