package cloud.web.simple.findJdbcDriver;

import cloud.web.simple.findJdbcDriver.domain.AllDbmsDriverDto;
import cloud.web.simple.findJdbcDriver.domain.InsertDbmsDriverDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dbms/jdbc/driver")
public class DriverRestController {
    private final DriverService driverService;

    @GetMapping
    public List<AllDbmsDriverDto> findAll(){
        return driverService.findAllDbmsDriver();
    }

    @PostMapping
    public boolean insertDriverInform(@RequestBody InsertDbmsDriverDto insertDbmsDriverDto){
        driverService.insertDriver(insertDbmsDriverDto);

        return true;
    }
}
