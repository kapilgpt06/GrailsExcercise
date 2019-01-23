package exercise

import demo.Subscription
import demo.Topic
import demo.User
import grails.gorm.transactions.Transactional

@Transactional
class SubscriptionService {

    def springSecurityService
    boolean isSubscribe(String id){
        User currentUser=springSecurityService.currentUser
        Topic topic=Topic.findById(id)
        Subscription subscription=new Subscription(user: currentUser,topic: topic)
        if(subscription.validate()){
            subscription.save(flush:true)
            true
        }else{
            false
        }
    }

    void unSubscribe(String id){
        User currentUser=springSecurityService.currentUser
        Topic topic=Topic.findById(id)
        Subscription subscription=Subscription.findByTopicAndUser(topic,currentUser)
        subscription.delete()

    }
    def serviceMethod() {

    }
}
