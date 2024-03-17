package com.market.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;

    private String phone;
    private String address;
    private String avatar;

}
