package edu.ait.lawyer.dto.ResponseBody;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class ResponseBody {
    private HashMap<String , List<String>> response = new HashMap<>();

    public void addResponse(String status, String message){
        this.response.computeIfAbsent(status, k -> new ArrayList<>()).add(message);
    }
}
