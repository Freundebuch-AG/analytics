package com.freundebuchag.analytics.TopLongDino;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@Builder
public class TopLongDinoResource {
    @JsonProperty(value = "_id")
    private UUID id;

    String firstName;

    String lastName;

    String dino;
}
