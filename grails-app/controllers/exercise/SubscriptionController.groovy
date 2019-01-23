package exercise


import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class SubscriptionController {

    def springSecurityService
    def subscriptionService

    def index() {

    }

    def subscribe(){

        if(subscriptionService.isSubscribe(params.id)){
            flash.message="succesfully follow"
        }else{
            flash.message="already follow"
        }
        redirect(controller:"user")
    }

    def unSubscribe(){
        subscriptionService.unSubscribe(params.id)
        flash.message="UnSubscribe Successfully"
        redirect(controller: "user")
    }
}
