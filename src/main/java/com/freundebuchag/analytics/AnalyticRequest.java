package com.freundebuchag.analytics;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class AnalyticRequest {

    String firstName;

    String lastName;

    LocalDate bday;

    String food;

    String animal;

    String dino;
}
