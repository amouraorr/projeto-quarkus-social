package com.alex.quarkussocial.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "followers", schema = "quarkus_social")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "followers_id")
    private User follower;
}
