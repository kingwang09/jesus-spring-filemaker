package org.jesus.jesusspring;

import lombok.extern.slf4j.Slf4j;
import org.jesus.jesusspring.filemaker.FileMakerRepository;
import org.jesus.jesusspring.hello.entity.Hello;
import org.jesus.jesusspring.hello.entity.HelloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class JesusSpringApplicationTests {

	@Autowired
	private HelloRepository helloRepository;

	@Autowired
	private FileMakerRepository fileMakerRepository;

	@Test
	void contextLoads() {

		List<Hello> helloList = helloRepository.findAll();
		log.debug("helloList: {}", helloList);
	}

	@Test
	public void fileMakerRepositoryTest(){
		fileMakerRepository.test();
	}

	@Test
	public void setFileMakerRepositoryHelloListTest(){
		log.info("results: {}", fileMakerRepository.selectHelloList());
	}
}
