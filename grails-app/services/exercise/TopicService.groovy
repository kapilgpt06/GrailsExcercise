package exercise

import demo.Topic
import demo.User
import grails.gorm.transactions.Transactional

@Transactional
class TopicService {

    def springSecurityService
    boolean isCreateTopic(String name){
        User user=springSecurityService.currentUser
        Topic topic=new Topic(name:name,createdBy: user )
        if(topic.validate()){
            topic.save(flush:true)
            true
        }else{
            false
        }
    }
    def serviceMethod() {

    }
}
