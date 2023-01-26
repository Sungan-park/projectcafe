package com.example.cafe.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cadmin")
@SequenceGenerator(name = "cadmin_seq_GENERATOR",sequenceName = "cadmin_seq", allocationSize = 1, initialValue = 1)
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cadmin_seq_GENERATOR")
    @Column
    Long id;
    @Column
    String userid;
    @Column
    String pw;
}