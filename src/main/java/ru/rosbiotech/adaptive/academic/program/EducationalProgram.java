package ru.rosbiotech.adaptive.academic.program;

import jakarta.persistence.*;

@Entity
@Table(name = "educational_program")
public class EducationalProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    protected EducationalProgram() {
    }

    public EducationalProgram(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}