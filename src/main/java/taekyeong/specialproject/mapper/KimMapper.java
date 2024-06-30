package taekyeong.specialproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import taekyeong.specialproject.domain.Kim;

@Mapper
public interface KimMapper {

    public Kim findById(int id);
}
