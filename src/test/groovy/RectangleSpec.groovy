import spock.lang.Shared
import spock.lang.Specification

class RectangleSpec extends Specification{
    @Shared
    GroovyObject obj

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader()).parseClass(new File("src/main/groovy/rectangle.groovy"))
      obj = cls.getDeclaredConstructor().newInstance()
    }

//    def setup() {
//        Class cls = new GroovyClassLoader(getClass().getClassLoader()).parseClass(new File("src/main/groovy/rectangle.groovy"))
//        obj = cls.getDeclaredConstructor().newInstance()
//    }

//    def "test the perimeter function of a rectangle"() {
//
//
//        given:
//        def length = 10
//        def breadth = 5
//
//        expect:
//        obj.perimeter(length,breadth) == 30
//    }
//
//    def "test the area function of a rectangle" () {
//
//        given:
//        def length = 10
//        def breadth = 5
//
//        expect:
//        obj.area(length,breadth) == 50
//    }

    def "test length and breadth for perimeter" () {
        expect:
        obj.perimeter(length,breadth) == expected

        where:
        length | breadth || expected
        10     | 5       || 30

    }

    def "test length and breadth for area" () {
        expect:
        obj.area(length,breadth) == expected

        where:
        length | breadth || expected
        10     | 5       || 50

    }
}
