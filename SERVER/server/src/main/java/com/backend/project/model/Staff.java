package com.backend.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
    
    @Id
    @Column(name = "username")
    private String username;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Column(name = "name")
    private String staff_name;

    public String getName(){
        return staff_name;
    }

    public void setName(String staff_name){
        this.staff_name = staff_name;
    }

    @Column(name = "role")
    private int role;

    public int getRole(){
        return role;
    }

    public void setRole(int role){
        this.role = role;
    }

    @Column(name = "email")
    private String email;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Column(name = "password")
    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
