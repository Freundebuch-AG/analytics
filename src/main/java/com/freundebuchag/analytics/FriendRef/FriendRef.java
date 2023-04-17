package com.freundebuchag.analytics.FriendRef;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freundebuchag.analytics.TopLongDino;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "FRIEND_REF")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class FriendRef {
    @JsonProperty("_id")
    @Id
    private UUID id;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTHDAY", nullable = false)
    private LocalDate bday;

    @Column(name = "FOOD")
    private String food;

    @Column(name = "ANIMAL")
    private String animal;

    @Column(name = "DINO")
    private String dino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dinoId")
    private TopLongDino topLongDino;
}
