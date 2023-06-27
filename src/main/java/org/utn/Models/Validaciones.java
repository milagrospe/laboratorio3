package org.utn.Models;

import org.utn.Excepciones.InvalidDateFormatException;
import org.utn.Excepciones.InvalidEmailException;
import org.utn.Excepciones.InvalidPasswordException;

public class Validaciones {

    public static void validateEmail(String email) throws InvalidEmailException {
        if (!email.matches("\\b[A-Za-z0-9._%+-]+@(gmail\\.com|hotmail\\.com|yahoo\\.com)\\b")) {
            System.out.println("Estoy entrendo en este if");
            throw new InvalidEmailException("El email ingresado no es válido.");
        }
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() != 6 || !password.matches("[a-zA-Z0-9]+")) {
            throw new InvalidPasswordException("La contraseña ingresada no es válida.");
        }
    }

    public static void validateDateFormat(String input) throws InvalidDateFormatException {
        if (!input.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new InvalidDateFormatException("El formato de fecha ingresado no es válido.");
        }

        String[] parts = input.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1923 || year > 2100) {
            throw new InvalidDateFormatException("La fecha ingresada no es válida.");
        }
    }
}
