package com.books.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookDetails {
    @JsonProperty("title")
    String bookTitle;
//    @JsonProperty()
//    String bookAuthor;
    @JsonProperty("publish_date")
    String year;
    @JsonProperty("publishers")
    List<String> publisher;
    @JsonProperty("isbn_13")
    List<String> isbn;
    @JsonProperty("number_of_pages")
    Integer numberOfPages;

}
