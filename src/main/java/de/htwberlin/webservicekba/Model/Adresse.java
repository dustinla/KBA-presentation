package de.htwberlin.webservicekba.Model;


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

    @JsonProperty("Postleihzahl")
    @JsonAlias("plz")
    @Column(length = 5)
    private String plz;
}
