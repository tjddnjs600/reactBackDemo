package com.back.demo.todo.service.impl;

import com.back.demo.todo.entity.TodoEntity;
import com.back.demo.todo.repository.TodoRepository;
import com.back.demo.todo.service.TodoService;
import com.back.demo.todo.vo.TodoListVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public List<TodoListVo> selectList() {
        List<TodoListVo> list = new ArrayList<>();

        List<TodoEntity> selectList = this.todoRepository.findAll().stream()
                .map(todo -> {
                    TodoListVo vo = new TodoListVo();
                    vo.setId(String.valueOf(todo.getId()));
                    vo.setText(todo.getText());
                    vo.setChecked(vo.prodChecked(todo.getChecked()));

                    list.add(vo);
                    return todo;
                }).collect(Collectors.toList());

        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TodoListVo insertTodo(TodoListVo todoListVo) {
        TodoEntity save = this.setTodoEntity(todoListVo);
        if(!StringUtils.isEmpty(todoListVo.getId())){
            save.setId(Integer.parseInt(todoListVo.getId()));
        }
        TodoEntity entity = this.todoRepository.save(save);

        return new TodoListVo(String.valueOf(entity.getId())
                            , entity.getText()
                            , todoListVo.prodChecked(entity.getChecked()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteList(TodoListVo todoListVo) throws Exception {

        this.todoRepository.deleteById(Integer.parseInt(todoListVo.getId()));

        return "ok";
    }

    private TodoEntity setTodoEntity(TodoListVo todoListVo){
        TodoEntity entity = new TodoEntity();
        entity.setText(todoListVo.getText());
        entity.setChecked(todoListVo.consChecked(todoListVo.isChecked()));
        return entity;
    }
}
