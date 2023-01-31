package com.back.demo.todo.controller;

import com.back.demo.todo.service.TodoService;
import com.back.demo.todo.vo.TodoListVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;

    @GetMapping("/selectList")
    public List<TodoListVo> selectList(){
        return this.todoService.selectList();
    }

    @PostMapping("/insertList")
    public TodoListVo insertList(@RequestBody TodoListVo todoListVo){
        log.debug(todoListVo.toString());
        return this.todoService.insertTodo(todoListVo);
    }

    @PostMapping("/deleteList")
    public String deleteList(@RequestBody TodoListVo todoListVo){
        log.debug(todoListVo.toString());
        String res;
        try {
            res = this.todoService.deleteList(todoListVo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
