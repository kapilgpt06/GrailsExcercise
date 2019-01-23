package exercise

import demo.Subscription
import demo.Topic
import demo.User
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

import javax.servlet.http.HttpServletResponse

@Secured('ROLE_USER')
class UserController {

    def RedirectStrategy
    def userService

    def index() {

        List<User> userList=userService.getUserList()

        Set<Topic> myTopicList=userService.getMyTopicList()

        Set<Topic> otherTopicList=userService.getOtherTopicList()

        List<Topic> followedTopic=userService.getFollowedTopic()

        [userList:userList,myTopicList:myTopicList,otherTopicList:otherTopicList,followedTopic:followedTopic,message:flash.message]


    }

    def logOut(){
        if (!request.post && SpringSecurityUtils.getSecurityConfig().logout.postOnly) {
            response.sendError HttpServletResponse.SC_METHOD_NOT_ALLOWED // 405
            return
        }

        // TODO put any pre-logout code here
        redirectStrategy.sendRedirect request, response, SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/logoff'
        response.flushBuffer()
    }
}
