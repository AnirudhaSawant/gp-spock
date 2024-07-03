import spock.lang.Shared
import spock.lang.Specification

class EvenOddSpec extends Specification{
    @Shared
    GroovyObject obj

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader()).parseClass(new File("src/main/groovy/even_odd.groovy"))
        obj = cls.getDeclaredConstructor().newInstance()
    }

    def "test even odd numbers" () {
        expect:
        obj.evenOdd(n) == expected

        where:
        n | expected
        9 | 'Odd'
        10 | 'Even'
        0 | 'Even'
    }

//    def "test the number is odd"() {
//        given:
//        def n = 9
//
//        expect:
//        obj.evenOdd(n) == 'Odd'
//
//    }
//
//    def "test the number is even"() {
//        given:
//        def n = 10
//
//        expect:
//        obj.evenOdd(n) == 'Even'
//    }
}
