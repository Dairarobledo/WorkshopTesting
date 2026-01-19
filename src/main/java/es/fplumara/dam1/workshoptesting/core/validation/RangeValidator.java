package es.fplumara.dam1.workshoptesting.core.validation;

public class RangeValidator {

    public boolean isValidAge(int age) {
        return age >= 0 && age <= 121;
    }

    public boolean isNonBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}