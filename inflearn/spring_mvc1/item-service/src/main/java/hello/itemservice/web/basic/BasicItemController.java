package hello.itemservice.web.basic;


import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
public class BasicItemController {
    private final ItemRepository itemRepository;

    @Autowired
    public BasicItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping()
    public String items(Model model){
        List<Item> items= itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }


    //초기 상품 등록
    @PostMapping
    public void init(){
        itemRepository.save(new Item("itmeA",10000,10));
        itemRepository.save(new Item("itmeB",20000,20));
    }

}
