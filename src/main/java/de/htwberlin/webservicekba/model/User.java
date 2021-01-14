package de.htwberlin.webservicekba.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_entity") // Datenbanken mögen keine Tables die User heißen. Deswegen wir diese explizit umbenannt.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String vorname;

    private String nachname;

    private Adresse adresse;
}
