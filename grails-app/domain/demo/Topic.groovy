package demo

import grails.plugin.springsecurity.annotation.Secured

class   Topic {

    String name
    User createdBy
    static hasMany = [subscriptions: Subscription, resources: Resource]

    static constraints = {
          createdBy nullable: false
        name nullable: false, blank: false, validator: { val, obj ->
            User user =obj.createdBy
                if (user.topics!=null && user.topics.name.contains(val)) {
                    return "topic should be unique per user"
            }
        }
    }
}

