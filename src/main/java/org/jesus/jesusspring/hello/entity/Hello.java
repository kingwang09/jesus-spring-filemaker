package org.jesus.jesusspring.hello.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hello {
    @Id
    private String id;

    private String name;

    private LocalDateTime registered;
}
