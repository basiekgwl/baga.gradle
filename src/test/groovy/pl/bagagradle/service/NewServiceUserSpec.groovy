package pl.bagagradle.service

import pl.bagagradle.dao.UsersRepository
import spock.lang.Specification

class NewServiceUserSpec extends Specification {

    def repository = Mock(UsersRepository)

    def saveUserService = Mock(SaveUserService)

    def service = new NewServiceUser(repository, saveUserService)

    def "test baga"() {
        given:
        def name = "Baga"

        when:
        def result = service.getMessage()

        then:
        result.getMessage() == "Hello Baga!!!"
    }

}
