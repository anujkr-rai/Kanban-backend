package com.betsol.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long user_id;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="first_name")
	private String first_name;
    
    @Column(name="last_name")
	private String last_name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private List<Task> list;

	public UserDao() {
    }

    public UserDao(String first_name,String last_name, Long id, String username, String password) {
		super();
		this.user_id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username=username;
        this.password=password;
        
	}

    public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}



    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

}

