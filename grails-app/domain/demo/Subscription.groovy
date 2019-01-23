package demo

class Subscription {

    def springSecurityService

    User user
    Topic topic

    static constraints = {
        user nullable: false,validator: { val,obj->
            def currentUserSub=Subscription.findAllByUser(val)
            if(currentUserSub.topic.contains(obj.topic)){
                return "already isSubscribe"
            }
        }
        topic nullable: false
    }
}
