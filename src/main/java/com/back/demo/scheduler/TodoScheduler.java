package com.back.demo.scheduler;

import com.back.demo.todo.entity.TodoEntity;
import com.back.demo.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class TodoScheduler {

    private TodoRepository todoRepository;

    @Scheduled(cron = "0 0 12 1 * *")
    @Transactional(rollbackFor = Exception.class)
    public void todoListScheduler(){

        List<TodoEntity> todoList = this.todoRepository.findAll()
                .stream().filter(chk -> "T".equals(chk.getChecked())).collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(todoList)){
            this.todoRepository.deleteAll(todoList);
        }
    }
}
