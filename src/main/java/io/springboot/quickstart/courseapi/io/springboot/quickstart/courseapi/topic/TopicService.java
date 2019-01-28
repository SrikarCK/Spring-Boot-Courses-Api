package io.springboot.quickstart.courseapi.io.springboot.quickstart.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    //Before using JPA and embedded tomcat.
//    private List<Course> topics =  new ArrayList<>(Arrays.asList(
//            new Course("Spring","Spring FrameWork","Spring FrameWork Description"),
//                new Course("Java","Core Java","Core Java Description"),
//                new Course("Mysql","Mysql Database","Mysql Database Description")
//        )) ;

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        //return  topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size() ; i++) {
//            Course t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i,Course);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
