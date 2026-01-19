package es.fplumara.dam1.workshoptesting.auth;

public record UserAccount(String email, String passwordHash, boolean active) {
}