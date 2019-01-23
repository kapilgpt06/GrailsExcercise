package demo


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String name
    String username
    String password
    static hasMany = [topics: Topic,subscriptions:Subscription,resources:Resource]
    boolean enabled = true
    boolean accountExpired


    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        name nullable: false,blank: false
        password nullable: false, blank: false, password: true ,minSize: 5 ,validator: { val,User obj->
            if(obj.name.equals(val)){
                return "password should be not be same as your name"
            }
        }
        username nullable: false, blank: false, unique: true, email: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
