package com.epam.ta.bo;

/**
 * Created by Pavel_Kotionov on 6/13/2018.
 */
public class Account {
    private String username, password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(AccountBuilder accountBuilder) {
        this.username = accountBuilder.username;
        this.password = accountBuilder.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class AccountBuilder {
        private String username, password;

        public AccountBuilder() {
        }

        public AccountBuilder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public AccountBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Account build() {
            Account account = new Account(this);
            return account;
        }
    }
}
