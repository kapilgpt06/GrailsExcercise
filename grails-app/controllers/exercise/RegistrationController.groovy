package exercise

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class RegistrationController {

    def registrationService
    def index() { }

    def register(){
        registrationService.register(params.name,params.email,params.password)
        flash.message="confirmation mail is send tpo your account"
        redirect(controller:"user" )
    }

    def confirm(){
        if(registrationService.isConfirm(params.token)){
           flash.message="account successfully confirmed"
        }else{
            flash.message="something going wrong"
        }
        redirect(controller: "user")
    }
}
