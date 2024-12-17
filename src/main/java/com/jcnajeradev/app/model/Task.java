package com.jcnajeradev.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TITLE")
    public String title;
    @Column(name = "DESCRIPTION")
    public String description;
    @Column(name = "STATUS")
    public boolean status;
}
