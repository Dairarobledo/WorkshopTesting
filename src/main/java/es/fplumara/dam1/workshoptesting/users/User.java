package es.fplumara.dam1.workshoptesting.users;

import java.util.UUID;

public record User(UUID id, String email, boolean active) { }