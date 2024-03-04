package br.com.cryslefundes.core.enums;

public enum UserRole {
    ADMIN,
    COMMON;

    public UserRole roleToString(String role) {
        for (UserRole r: UserRole.values()) {
            if (r.toString().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Role invalid!");
    }
}
