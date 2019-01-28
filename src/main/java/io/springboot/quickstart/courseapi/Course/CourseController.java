package io.springboot.quickstart.courseapi.Course;

import io.springboot.quickstart.courseapi.io.springboot.quickstart.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  CourseController {

    @Autowired
    private CourseService courseService;

    //Get Method
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String  id){
        return courseService.getAllCourses(id);
    }

    //Get By {Id} Method.
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    //Post Method.
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    //Update By {Id} Method.
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId,@PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    //Delete By {Id} Method.
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}" )
    public void deleteCourse(@PathVariable String id){
         courseService.deleteCourse(id);
    }
}
