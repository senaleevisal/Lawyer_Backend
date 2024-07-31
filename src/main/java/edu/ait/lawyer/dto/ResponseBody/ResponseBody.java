// src/main/java/edu/ait/lawyer/dto/ResponseBody/ResponseBody.java
package edu.ait.lawyer.dto.ResponseBody;

import edu.ait.lawyer.dao.Lawyer;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ResponseBody {
    private HashMap<String , List<Object>> response = new HashMap<>();

    public void addResponse(String status, String message){
        this.response.computeIfAbsent(status, k -> new ArrayList<>()).add(message);
    }

    public void addLawyers(List<Lawyer> lawyers) {
        this.response.computeIfAbsent("lawyers", k -> new ArrayList<>()).addAll(lawyers);
    }
}
