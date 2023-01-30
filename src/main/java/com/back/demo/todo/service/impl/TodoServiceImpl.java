package com.back.demo.todo.service.impl;

import com.back.demo.todo.service.TodoService;
import com.back.demo.todo.vo.TodoListVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Override
    public List<TodoListVo> selectList() {
        List<TodoListVo> list = new ArrayList<>();
        TodoListVo vo = TodoListVo.builder().id("0").text("ReactTitle").checked(false).build();
        list.add(vo);
        return list;
    }
}
