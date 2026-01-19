package es.fplumara.dam1.workshoptesting.users;

import java.util.List;

public class BulkRegistrar {
    private final UserService service;
    public BulkRegistrar(UserService service) { this.service = service; }

    public void registerAll(List<String> emails) {
        for (String email : emails) {
            service.register(email);
        }
    }
}