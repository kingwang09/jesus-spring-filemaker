package org.jesus.jesusspring.hello;

import lombok.RequiredArgsConstructor;
import org.jesus.jesusspring.hello.entity.Hello;
import org.jesus.jesusspring.hello.entity.HelloRepository;
import org.jesus.jesusspring.hello.mapper.HelloMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloRepository helloRepository;
    private final HelloMapper helloMapper;
    @GetMapping
    public List<Hello> getAll(){
        return helloMapper.selectList();
    }

    @GetMapping("/jpa")
    public List<Hello> findAll(){
        return helloRepository.findAll();
    }
}
