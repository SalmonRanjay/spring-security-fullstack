package com.ranjay.spring.nhssytems.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

   
    @Id
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min=4)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
    private boolean enabaled = true;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
        @JoinColumn(referencedColumnName = "email",name="USER_EMAIL" )
    },inverseJoinColumns = {
        @JoinColumn(referencedColumnName = "name", name="ROLE_NAME")
    })
    private List<Role> roles;

    
   

    public User(String email, String userName, String password) {
        this.email = email;
        this.name = userName;
        this.password = password;
    }

    public User(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isEnabaled() {
        return enabaled;
    }

    public void setEnabaled(boolean enabaled) {
        this.enabaled = enabaled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

  

}