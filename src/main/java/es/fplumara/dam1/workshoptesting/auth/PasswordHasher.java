package es.fplumara.dam1.workshoptesting.auth;

public interface PasswordHasher {
    String hash(String rawPassword);
}