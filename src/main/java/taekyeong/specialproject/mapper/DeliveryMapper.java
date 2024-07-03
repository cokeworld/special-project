package taekyeong.specialproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import taekyeong.specialproject.domain.Delivery;

@Mapper
public interface DeliveryMapper {

    public int save(Delivery delivery);
    public Delivery findById(int id);
}
