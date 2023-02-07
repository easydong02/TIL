package hello.itemservice.web.item.basic;
import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.List;
@Controller
@RequestMapping("/basic/items")
//@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;


    @Autowired
    public BasicItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }



    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }
//    @PostMapping("/add")
    public String save(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        model.addAttribute("item",item);
        itemRepository.save(item);

        return "basic/item";
    }

    //ModelAttribute는 Model객체도 포함, 알아서 넣어준다.
    @PostMapping("/add")
    public String saveV2(@ModelAttribute("item") Item item){

//        model.addAttribute("item",item);
        itemRepository.save(item);

        return "basic/item";
    }
    //ModelAttribute는 Model객체도 포함, 알아서 넣어준다.
//    @PostMapping("/add")
    public String saveV3(@ModelAttribute Item item){

//        model.addAttribute("item",item);
        itemRepository.save(item);

        return "basic/item";
    }


    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }
}