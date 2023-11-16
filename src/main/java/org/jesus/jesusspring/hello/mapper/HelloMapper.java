package org.jesus.jesusspring.hello.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jesus.jesusspring.hello.entity.Hello;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HelloMapper {

    List<Hello> selectList();
}
