package taekyeong.specialproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taekyeong.specialproject.domain.Kim;
import taekyeong.specialproject.mapper.KimMapper;

@RequiredArgsConstructor
@Service
public class KimService {

    private final KimMapper kimMapper;

    @Transactional
    public Kim findById(Integer id) {
        Kim kim = kimMapper.findById(id);
        return kim;
    }
}
