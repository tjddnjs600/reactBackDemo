package com.back.demo.todo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoListVo {
    private String id;

    private String text;

    private boolean checked;

    private String user_id;

    public Boolean prodChecked(String checked){
        if("F".equals(checked))
            return false;
        else
            return true;
    }

    public String consChecked(boolean checked){
        if(checked)
            return "T";
        else
            return "F";
    }
}
