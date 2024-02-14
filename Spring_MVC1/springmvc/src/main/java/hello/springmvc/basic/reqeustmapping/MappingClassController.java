package hello.springmvc.basic.reqeustmapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user(){
        return "get users";
    }

    @PostMapping("/{userId}")
    public  String addUser(@PathVariable String userId){
        return "post user" + userId;
    }

    @GetMapping("/{userId}")
        public String findUser(@PathVariable String userId){
        return "get userId="+ userId;
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId="+ userId;
    }

    @DeleteMapping("/{userId}")
    public String delteUser(@PathVariable String userId){
        return "delete userId= "+userId;
    }

}
