package first.mvc.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
/*
    private final BookDaoImp bookDaoImp;

    public BookController(BookDaoImp bookDaoImp) {this.bookDaoImp = bookDaoImp;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDaoImp.readAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDaoImp.readById(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "books/new";
        }
        bookDaoImp.create(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookDaoImp.readById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "books/edit";
        }
        bookDaoImp.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDaoImp.delete(id);
        return "redirect:/books";
    }
*/
}
