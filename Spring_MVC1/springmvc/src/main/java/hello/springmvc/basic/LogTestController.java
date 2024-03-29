package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @Slf4j
    @RestController //controller는 view를 반환, restcontroller는 데이터 반환.
    public class LogTestController {

        //기본은 info level
        //private final Logger log = LoggerFactory.getLogger(getClass());

        @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";


        log.trace("trace log ={}",name);
        log.debug("debug log ={}",name);
        log.info("info log = {}",name); // INFO 프로세스 아이디 스레드 아이디 위치 로그
        log.warn("warn log ={}",name);
        log.error("error log ={}",name);

        return "ok";
    }
}
