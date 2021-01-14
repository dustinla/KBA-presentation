package de.htwberlin.webservicekba.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Adresse {

    private String strassenname;

    private String strassennummer;

    @JsonProperty("Postleitzahl")
    @JsonAlias("plz")
    @Column(length = 5)
    private String plz;
}
