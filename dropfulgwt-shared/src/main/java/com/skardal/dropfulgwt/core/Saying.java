package com.skardal.dropfulgwt.core;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
	@JsonProperty
    private final long id;

    @Length(max = 3)
    @JsonProperty
    private final String content;

    @JsonCreator
    public Saying(
    		@JsonProperty("id") long id, 
    		@JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }

    
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}