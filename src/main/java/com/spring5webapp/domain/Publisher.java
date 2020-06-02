package com.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@ToString(exclude = {"books"})
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"books"})
@RequiredArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String zipCode;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Set<Book> books = new HashSet<Book>();
}
