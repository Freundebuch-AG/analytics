package com.freundebuchag.analytics.TopLongDino;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freundebuchag.analytics.FriendRef.FriendRef;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TOP_LONG_DINO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TopLongDino {
    @JsonProperty("_id")
    @Id
    @GeneratedValue
    private UUID dinoId;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @ManyToOne(targetEntity = FriendRef.class, cascade = CascadeType.ALL)
    private FriendRef friendRef;
}
