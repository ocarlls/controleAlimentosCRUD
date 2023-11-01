package com.projeto.gerenciamentoAlimentos.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {
    ADMIN("admin"),
    USER("user");
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
