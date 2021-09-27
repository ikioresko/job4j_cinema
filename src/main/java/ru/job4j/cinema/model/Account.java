package ru.job4j.cinema.model;

import java.util.Objects;

public class Account {
    private int id;
    private String username;
    private String email;
    private int phone;

    public static Account accountOf(int id, String username, String email, int phone) {
        Account account = new Account();
        account.id = id;
        account.username = username;
        account.email = email;
        account.phone = phone;
        return account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return id == account.id
                && phone == account.phone
                && Objects.equals(username, account.username)
                && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, phone);
    }

    @Override
    public String toString() {
        return "Account{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", email='" + email + '\''
                + ", phone=" + phone
                + '}';
    }
}
