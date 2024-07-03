import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification

class FibonacciSpec extends Specification{
    @Shared
    GroovyObject obj

    @Shared
    def inputs

    @Shared
    def outputs

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader()).parseClass(new File("src/main/groovy/fibo_series.groovy"))
        obj = cls.getDeclaredConstructor().newInstance()

        def jsonSlurper = new JsonSlurper()
        def obj = jsonSlurper.parse(new File("src/test/groovy/fibo_series.json"))
        inputs = obj['inputs']
        outputs = obj['outputs']
    }

    def "test fibo series"() {
        expect:
        obj.fibonacci(n) == expected

        where:
//        n << [8,5]
//        expected << [[0,1,1,2,3,5,8,13],[0,1,1,2,3]]

        n << inputs
        expected << outputs
    }

    def "test fibo series for n < 2" () {
        given:
        def n = 1

        when:
        obj.fibonacci(n)

        then:
        IllegalArgumentException e = thrown()
        e.message == 'value must be greater than 2'
    }

    def "test fibo series for not throwning exception for n >= 2" () {
        def n = 3
        when:
        obj.fibonacci(n)

        then:
        notThrown(IllegalArgumentException)
    }

//    def "test the fibonacci numbers series" () {
//        expect:
//        obj.fibonacci(n) == expected
//
//        where:
//        n | expected
//        8 | [0, 1, 1, 2, 3, 5, 8, 13]
//        5 | [0, 1, 1, 2, 3]
//    }
}
