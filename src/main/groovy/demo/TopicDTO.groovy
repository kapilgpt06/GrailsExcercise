package demo

class TopicDTO {
    long id
    String name
    UserDTO createdBy
    List<Subscription> subscriptions
    List<Resource> resources
}
