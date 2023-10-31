package user.model;

import com.fasterxml.jackson.annotation.JsonAlias;



public class User {
    @JsonAlias({"id"})
    private Integer id;
    @JsonAlias({"username"})
    private String username;
    @JsonAlias({"password"})
    private String password;

    @JsonAlias({"coins"})
    private Integer coins;


    // Jackson needs the default constructor
    public User() {

    }

    public User(Integer id, String username, String password, Integer coins) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coins = coins;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Integer getCoins() {
        return coins;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCoins(Integer coins) {
        this.coins = coins;
    }

}
