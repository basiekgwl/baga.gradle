
import pl.bagagradle.service.NewServiceCar
import spock.lang.Specification

class NewServiceCarSpec extends Specification {


    def service = new NewServiceCar()

    def "test baga"() {
        given:
        def name = "Baga"
        when:

        def result = service.getMessage()
        then:
        result.getMessage() == "Hello Baga!!!"
    }

}
