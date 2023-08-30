package cloud.web.simple.findJdbcDriver;

import cloud.web.simple.entity.driver.JdbcDriver;
import cloud.web.simple.findJdbcDriver.domain.AllDbmsDriverDto;
import cloud.web.simple.findJdbcDriver.domain.InsertDbmsDriverDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DriverService {

    private final DriverRepository driverRepository;

    public void insertDriver(InsertDbmsDriverDto insertDbmsDriverDto){

        JdbcDriver jdbcDriver = new JdbcDriver();
        jdbcDriver.setDbmsNameKor(insertDbmsDriverDto.getDbmsNameKor());
        jdbcDriver.setDbmsNameEng(insertDbmsDriverDto.getDbmsNameEng());
        jdbcDriver.setDriverUrl(insertDbmsDriverDto.getDriverUrl());
        jdbcDriver.setDriverClass(insertDbmsDriverDto.getDriverClass());

        driverRepository.save(jdbcDriver);
    }

    public List<AllDbmsDriverDto> findAllDbmsDriver(){
         return driverRepository.findAll().stream().map(d ->
             new AllDbmsDriverDto(
                     d.getId(),
                     d.getDbmsNameKor(),
                     d.getDbmsNameEng(),
                     d.getDriverClass(),
                     d.getDriverUrl()
             )
         ).collect(Collectors.toList());
    }
}
