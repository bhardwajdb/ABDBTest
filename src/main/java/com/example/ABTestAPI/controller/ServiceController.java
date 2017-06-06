package com.example.ABTestAPI.controller;

/**
 * Created by diwakar on 4/6/17.
 */

import com.example.ABTestAPI.dao.ExperimentDao;
import com.example.ABTestAPI.dao.GoalDao;
import com.example.ABTestAPI.dao.VariantDao;
import com.example.ABTestAPI.model.Experiment;
import com.example.ABTestAPI.model.Goal;
import com.example.ABTestAPI.model.Variant;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ServiceController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicInteger ctr = new AtomicInteger();
    private final AtomicInteger ctr1 = new AtomicInteger();

    @ResponseBody
    @RequestMapping(value ="/experiment",method= RequestMethod.POST)
    public Experiment greeting(@RequestBody Experiment experiment) {
        new ExperimentDao().addExperiment(experiment);
        return experiment;
    }

    @ResponseBody
    @RequestMapping(value ="/goal",method= RequestMethod.POST)
    public Goal goal(@RequestBody Goal goal) {
        new GoalDao().addGoal(goal);
        return goal;
    }

    @ResponseBody
    @RequestMapping(value ="/variant",method= RequestMethod.POST)
    public Variant greeting(@RequestBody Variant variant) {
        new VariantDao().addVariant(variant);
        return variant;
    }

    @ResponseBody
    @RequestMapping(value ="/variant/{id}/goalReached", method=RequestMethod.POST)
    public Variant incrementCount(@PathVariable("id") int id)
    {
        return new VariantDao().incrementGoalCount(id);
    }

    @ResponseBody
    @RequestMapping(value ="/experiment/{id}/getJavaScript", method=RequestMethod.POST)
    public String getJS(@PathVariable("id") int id)
    {
        List<Variant> lstVariant = new VariantDao().getVariantsOfExperiment(id);
        Experiment experiment = new ExperimentDao().getExperiment(id);
        Goal goal = new GoalDao().getGoalByExperiment(experiment);
        String str = "function encode(string) {    var number = \"0x\";    var length = string.length;    for (var i = 0; i < length; i++)        number +=string.charCodeAt(i).toString(16);    return number;}\n" +
                "$( document ).ready(function() {";
        int len = lstVariant.size();

        for (int i=0;i<len;i++)
        {
            str = str+"if( encode(document.cookie.split('=')[1])%"+(i+1)+"==0){$('."+experiment.getHtmlClassName()+".css(\""+experiment.getCssAttributeKey()+"\", \""+lstVariant.get(i).getCssAttributeValue()+"\");$('."+experiment.getHtmlClassName()+"')[0].onclick = function (e) {var xmlHttp = new XMLHttpRequest();xmlHttp.open(\"POST\", \"localhost:8080/variant/"+lstVariant.get(i).getId()+"/goalReached\", false);xmlHttp.send(null);}}";
        }

        str = str+"});";

        return str;
    }

}
