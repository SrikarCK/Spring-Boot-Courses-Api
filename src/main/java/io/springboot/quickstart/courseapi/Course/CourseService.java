package io.springboot.quickstart.courseapi.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Before using JPA and embedded tomcat.
//    private List<Course> topics =  new ArrayList<>(Arrays.asList(
//            new Course("Spring","Spring FrameWork","Spring FrameWork Description"),
//                new Course("Java","Core Java","Core Java Description"),
//                new Course("Mysql","Mysql Database","Mysql Database Description")
//        )) ;

    public List<Course> getAllCourses(String topicId){
        //return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
        //return  topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for (int i = 0; i < topics.size() ; i++) {
//            Course t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i,Course);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
