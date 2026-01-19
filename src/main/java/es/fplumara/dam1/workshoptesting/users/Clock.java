package es.fplumara.dam1.workshoptesting.users;

import java.time.Instant;

public interface Clock {
    Instant now();
}