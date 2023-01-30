package com.back.demo.todo.service;

import com.back.demo.todo.entity.TodoEntity;
import com.back.demo.todo.vo.TodoListVo;

import java.util.List;

public interface TodoService {

    List<TodoListVo> selectList();

    TodoListVo insertTodo(TodoListVo todoListVo);

    String deleteList(TodoListVo todoListVo) throws Exception;
}
