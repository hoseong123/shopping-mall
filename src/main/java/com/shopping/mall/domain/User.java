package com.shopping.mall.domain;

import javax.management.relation.Role;
import java.time.LocalDateTime;

public class User {
    private String id;
    private String email;
    private String password;
    private String name;
    private String provider;
    private int role_id;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    private Role role;

}
