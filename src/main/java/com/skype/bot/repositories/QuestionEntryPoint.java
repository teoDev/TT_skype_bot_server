package com.skype.bot.repositories;

import com.skype.bot.model.Question;
import com.skype.bot.model.Tag;
import lombok.extern.java.Log;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


/**
 * Created by surmab on 25.11.2016.
 */
@RestController
@ExposesResourceFor(Question.class)
@Log
public class QuestionEntryPoint {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    TagRepository tagRepository;
    @RequestMapping(value="/questions/search/find-by-tags",consumes = "application/json", produces = MediaTypes.HAL_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public Map<Integer,Integer> getQuestionsForTags(@RequestBody List<String> tags){
        log.info(tags.toString());
        Map<Integer,Integer> returnMap= new HashMap<>();
        List<Question> all = questionRepository.findAll();
        for (Question question: all){
            int fit =0;
            Set<Tag> questionTags = question.getTags();
            for (int i=0;i<tags.size();i++){
                String tag = tags.get(i);
                Tag foundTag = tagRepository.findByName(tag);
                if (foundTag!=null){
                    if (questionTags.contains(foundTag)){
                        fit++;
                    }
                }
            }
            if (fit>0) {
                returnMap.put(question.getId(),fit);
            }
        }
        return returnMap;
    }


}
