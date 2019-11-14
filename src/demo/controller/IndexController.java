package demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.System.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/context/index")
public class IndexController {

    @RequestMapping(value="/testIndex", method=GET)
    public String defaultMethod(@RequestParam(value="type", defaultValue="1")String type){
        out.println("IndexController.defaultMethod get msg:"+type);
        return "index/temp"+type;
    }

    @RequestMapping(value="/JsonDataFor")
    @ResponseBody
    public Map JsonDataMethod(@RequestParam(value="arg1", defaultValue="defaultValue")String arg1){
        out.println("JsonDataMethod get msg:"+arg1);
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("you post arg", arg1);
        if(true) return result;
        List<Map> list = new LinkedList<>();
        Map<String, Object> temp;
        for(int i=0;i<10;i++){
            temp = new HashMap<>();
            temp.put("key", "value"+i);
            list.add(temp);
        }
        result.put("list data", list);
        temp = new HashMap<>();
        temp.put("keyName", "ValueData");
        result.put("map data", temp);
        return result;
    }

    @RequestMapping(value="/JsonDataForRequestPayload")
    @ResponseBody
    public Map JsonDataMethod2(@RequestBody Map args){
        out.println("JsonDataMethod get msg:"+args.toString());
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("you post arg", args);
        if(true) return result;
        List<Map> list = new LinkedList<>();
        Map<String, Object> temp;
        for(int i=0;i<10;i++){
            temp = new HashMap<>();
            temp.put("key", "value"+i);
            list.add(temp);
        }
        result.put("list data", list);
        temp = new HashMap<>();
        temp.put("keyName", "ValueData");
        result.put("map data", temp);
        return result;
    }

}
