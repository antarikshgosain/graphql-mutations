package com.graphql.anta.mutations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String comment;

    public Review(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }
}
