import spock.lang.Specification

class StringOpsSpec extends Specification{
    def "test the subscript operator in string data"() {
        given:
        def str = 'good morning'

        //except: assertion only
        expect:
        str[0] == 'g'
        str[-1] == 'g'
        str[-2] == 'n'
        str[0..3] == 'good'
    }
}
