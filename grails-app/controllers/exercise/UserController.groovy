package exercise

import demo.Subscription
import demo.Topic
import demo.User
import grails.events.Events
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import grails.web.api.ServletAttributes
import org.hibernate.internal.SessionFactoryRegistry
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.session.SessionRegistry
import org.springframework.security.core.session.SessionRegistryImpl
import org.springframework.security.web.authentication.logout.LogoutHandler

import javax.servlet.http.HttpServletResponse

@Secured('ROLE_USER')
class UserController {

    def springSecurityService
    def RedirectStrategy
    def userService
    private SessionRegistry sessionRegistry;

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
