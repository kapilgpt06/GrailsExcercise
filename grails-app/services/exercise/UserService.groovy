package exercise

import demo.Subscription
import demo.Topic
import demo.TopicDTO
import demo.User
import demo.UserDTO
import grails.gorm.transactions.Transactional

@Transactional
class   UserService {

    def springSecurityService

    List<User> getUserList(){
        User currentUser=springSecurityService.currentUser
        List userList=User.findAllByUsernameNotEqual(currentUser.username)

        List userDTOList=[]
        userList.each {
            UserDTO userDTO=new UserDTO()
            userDTO.name=it.name
            userDTO.username=it.username

            List<TopicDTO> topicDTOList=[]
            it.topics.each {
                TopicDTO topicDTO=new TopicDTO()
                topicDTO.name=it.name
                topicDTOList.add(topicDTO)
            }
            userDTO.topics=topicDTOList
            userDTOList.add(userDTO)
        }

        userDTOList
    }

    Set<Topic> getMyTopicList(){
        User currentUser=springSecurityService.currentUser
        Set myTopicList=currentUser.topics

        Set topicDTOList=[]
        myTopicList.each {
            TopicDTO topicDTO=new TopicDTO()
            topicDTO.name=it.name
            topicDTOList.add(topicDTO)
        }
        topicDTOList
    }

    Set<Topic> getOtherTopicList(){
        User currentUser=springSecurityService.currentUser
        Set<Topic> otherTopicList=Topic.findAllByCreatedByNotEqual(currentUser)

        Set topicDTOList=[]
        otherTopicList.each {
            TopicDTO topicDTO=new TopicDTO()
            topicDTO.id=it.id
            topicDTO.name=it.name

            UserDTO userDTO=new UserDTO()
            userDTO.username=it.createdBy.username

            topicDTO.createdBy=userDTO
            topicDTOList.add(topicDTO)
        }
        topicDTOList
    }

    List<Topic> getFollowedTopic(){
        def list=Subscription.findAllByUser(springSecurityService.currentUser)
        List<Topic> followedTopic=list.topic

        List topicDTOList=[]
        followedTopic.each {
            TopicDTO topicDTO=new TopicDTO()
            topicDTO.id=it.id
            topicDTO.name=it.name

            UserDTO userDTO=new UserDTO()
            userDTO.username=it.createdBy.username

            topicDTO.createdBy=userDTO
            topicDTOList.add(topicDTO)
        }
        topicDTOList

    }
    def serviceMethod() {

    }
}
