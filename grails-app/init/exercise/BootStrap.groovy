package exercise

import demo.Role
import demo.Topic
import demo.User
import demo.UserRole

class BootStrap {

    def init = { servletContext ->
   /*     User kapil=new User(name: "kap", username: "kapil@kap.com",password: "kapil",enabled: true).save()
        User ankush=new User(name: "ank", username: "ankush@kap.com",password: "ankush",enabled: true).save()
        User manmohan=new User(name: "man", username: "manmohan@kap.com",password: "manmohan",enabled: true).save()

        Role userRole=new Role(authority: "ROLE_USER")
        userRole.save()

        UserRole.create(kapil,userRole)
        UserRole.create(ankush,userRole)
        UserRole.create(manmohan,userRole)

        Topic math=new Topic(name:  "math")
        Topic english=new Topic(name: "English")
        Topic hindi=new Topic(name: "Hindi")

        kapil.addToTopics(math)
            .addToTopics(english)
            .addToTopics(hindi).save(flush:true)
*/


    }
    def destroy = {
    }
}
