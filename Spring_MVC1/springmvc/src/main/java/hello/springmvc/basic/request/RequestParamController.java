package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

    @Slf4j
    @Controller
    public class RequestParamController {

        @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age= Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }


    // requestparam은 쿼리스트링, pathvariable은 슬래시(/)
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int age){
        log.info("username={}, age={}",memberName,age);

        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }


    //String,int,Integer 등 단순 타입이면 @RequestParam도 생략 가능
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,
                                 int age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }


    //required false 줬을 때 int 는 null을 받지 못하므로 Integer로 바꿔서 한다.
    //null 이랑 ""(빈문자) 다름.
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,
                                 @RequestParam(required = false) Integer age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }


    //디폴트 밸류가 있으면 required false여도 기본값으로 실행한다.
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1") Integer age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String,Object> paramMap){

        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));

        return "ok";
    }


    //modelAttribute는 객체를 받는다.
    //객체 생성하고 요청 파라미터의 이름으로 hellodata객체의  프로퍼티를  찾는다. 그리고 해당 프로퍼티의 setter호출해서 바인딩
    //프로퍼티의 타입 안 맞추면 바인딩익셉션 나옴.
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());

        return "ok";
    }

    //생략 가능 String, int, Integer 같은 단순타입 @RequestParam
    //나머지는 @ModelAttribute 근데 argument resolver로 지정해둔 타입 예외
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){

        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());

        return "ok";
    }

}
