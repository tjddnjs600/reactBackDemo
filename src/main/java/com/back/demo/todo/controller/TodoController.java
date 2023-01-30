package com.back.demo.todo.controller;

import com.back.demo.todo.service.TodoService;
import com.back.demo.todo.vo.TodoListVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public List<TodoListVo> insertList(@RequestBody String text){
        log.debug(text);
        return this.todoService.selectList();
    }
}
