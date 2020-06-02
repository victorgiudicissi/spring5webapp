package com.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Book> books  = new HashSet<>();
}
