package exercise

import demo.Role
import demo.User
import demo.UserRole
import demo.VerificationToken
import grails.gorm.transactions.Transactional

import java.sql.Timestamp

@Transactional
class RegistrationService {


    def register(String name,String email,String password){
        User user=new User(name: name,username: email,password: password,enabled: false)
        user.save()

        String token=UUID.randomUUID().toString()
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, 60);

        VerificationToken verificationToken=new VerificationToken(token: token,user: user,expiredDate: cal.getTime())
        verificationToken.save(flush:true)

        String useraddress=email
        String messageSubject="Registration Confirmation"
        String confirmationUrl="http://localhost:8080/registration/confirm?token="+token
        String message="click this link to confirm your account "+confirmationUrl
        sendMail{
            to useraddress
            subject messageSubject
            text message
        }
    }


    boolean isConfirm(String token) {
        VerificationToken verificationToken=VerificationToken.findByToken(token)

        if(verificationToken==null){
            return false
        }

        User user=verificationToken.user
        Calendar cal=Calendar.getInstance()
        if((verificationToken.expiredDate.getTime()-cal.getTime().getTime())<0)
        {
            return false
        }

        User.executeUpdate("update User set enabled=:enabled where id=:id",[enabled:true,id:user.id])
        Role roleUser=Role.findByAuthority("ROLE_USER")

        UserRole.create(user,roleUser,true)
        verificationToken.delete()
        true
    }
}
