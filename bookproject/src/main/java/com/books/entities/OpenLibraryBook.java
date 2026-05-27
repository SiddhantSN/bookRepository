package com.books.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenLibraryBook {

    @JsonProperty("bib_key")
    String ISBN;
    @JsonProperty("info_url")
    String info_url;
}
