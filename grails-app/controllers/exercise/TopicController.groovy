package exercise

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class TopicController {

    def topicService
    def show(){

    }
    def index() { }

    def create() {

    }

    def save(){
        if(topicService.isCreateTopic(params.name)){
            flash.message="succesfully create"
        }else{
            flash.message="topic should be unique"
        }
        redirect(controller:"user")
    }
}
