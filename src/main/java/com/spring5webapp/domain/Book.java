package com.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@ToString(exclude = {"author"})
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"author"})
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String title;

    @NonNull
    private String isbn;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "author_id")
    private Author author;

    @NonNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
