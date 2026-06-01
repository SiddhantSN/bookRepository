package com.books.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Data
public class BookDetails {
    @JsonProperty("title")
    public String bookTitle;
//    @JsonProperty()
//    String bookAuthor;

    @JsonProperty("authors")
    public List<Author> authors;
    @JsonProperty("publish_date")
    public String year;
    @JsonProperty("publishers")
    public List<String> publisher;
    @JsonProperty("isbn_13")
    public List<String> isbn;
    @JsonProperty("number_of_pages")
    public Integer numberOfPages;

}
