package org.jesus.jesusspring.hello.entity;

import org.jesus.jesusspring.hello.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, String> {
}
