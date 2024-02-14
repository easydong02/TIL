package hello.springmvc.basic.reqeustmapping;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 매핑과 String userId 처럼 변수명이 같으면 ("userId") 생략 가능
     * @param userId
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId){
        log.info("mappingPath userId={}", userId);

        return "ok";
    }
    @GetMapping("/mapping/user/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId){
        log.info("mappingPath userId={}", userId);
        log.info("mappingPath orderId={}", orderId);

        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * post라고 해도 text/html만 들어올 수 있고 application/json같은 것은 못들어온다.
     * @return
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }    
    
    /**
     * ContentType 헤더 기반
     * post라고 해도 application/json만 들어올 수 있고 text/html같은 것은 못들어온다.
     * @return
     */
    @PostMapping(value = "/mapping-produce", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(){
        log.info("mappingProduces");
        return "ok";
    }


}
