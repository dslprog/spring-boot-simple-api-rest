package com.cursofullstack.aplicacion.auth;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class AuthUtils {
    public static String createHash(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 2024, 1, password.toCharArray());
    }

    public static boolean verifyHash(String password1, String password2) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(password1, password2.toCharArray());
    }
}
