package ru.AnastTruh.helloandroid

import kotlin.time.Duration

/*
Создайте класс Robot с неизменяемыми свойствами model (строка), manufacturer
(строка) и year (целое). Переопределите toString() так, чтобы метод возвращал
строку вида «Model X200 (2023) — Robotics Corp». Создайте два разных робота и
выведите их представление
 */

class Robot(
    val model: String,
    val manufacturer: String,
    val year: Int){
    override fun toString(): String { return("$model - $manufacturer")}
}

fun task1(){
    val robot = Robot("Model", "Manuf", 10984)
    val robot_2 = Robot("Model_2", "cxxx12", 12032)
    println(robot.toString())
    println(robot_2.toString())
}

/*
Создайте класс Drone с первичным конструктором, принимающим только serial:
String. Добавьте вторичный конструктор, который помимо serial принимает range:
Int (максимальная дальность полёта в км). Во втором конструкторе вызовите
первый через this(serial) и инициализируйте свойство range. Продемонстрируйте
использование обеих форм конструкторов, выводя информацию о дронах
 */

class Drone(serial: String){

    var range: Int? = null
    var serial: String = serial

    constructor(range: Int, serial: String): this(serial) {
        this.range = range
    }
}

fun task2(){
   val drone = Drone("sqwert")
   val other_drone = Drone(23, "qwease")
    println(drone.serial)
    println("${other_drone.serial}, ${other_drone.range}")

}

/*
Определите класс Sensor, описывающий датчик со свойствами type (строка) и units
(строка). В блоке init автоматически присваивайте каждому созданному датчику
уникальный sensorId в формате “S-<номер>”, где номер увеличивается в companion
object. Создайте несколько сенсоров разных типов и выведите их sensorId

 */

class Sensor(
    val type: String,
    val units: String
){
    val sensorId: String

    init {
        sensorId = "S-${nextId++}"
    }

    companion object{
        private var nextId = 1
    }

}

fun task3(){
    val s1 = Sensor("AAA", "asd")
    val s2 = Sensor("BBB", "bsd")
    val s3 = Sensor("CCC", "ckd")
    println(s1.sensorId)
    println(s2.sensorId)
    println(s3.sensorId)
}

/*
Создайте класс Cylinder с параметрами radius и height. Для radius объявите сеттер,
который игнорирует попытку присвоить отрицательное значение. Добавьте
вычисляемое свойство volume (только геттер), считающее объём цилиндра по
формуле π · r² · h. Создайте цилиндр, попробуйте изменить radius на отрицательное
число, затем на положительное и в обоих случаях выведите volume
 */

class Cylinder(var height: Double){
    var radius: Double = 0.0
        set(value){
            if (value >= 0) field = value
        }

    val volume: Double
        get() = Math.PI * radius * radius * height
}

fun task4(){
    val first = Cylinder(3.0)
    first.radius = 2.5
    println(first.volume)
    println(first.radius)
    println()

    val second = Cylinder(3.0)
    second.radius = -2.5
    println(second.volume)
    println(second.radius)
}

/*
Определите открытый класс Instrument с виртуальной функцией play(): String,
возвращающей «…». Создайте подкласс Guitar, переопределив метод так, чтобы он
возвращал «Strum!». Создайте экземпляр Guitar и выведите результат вызова play()
 */

open class Instrument(){
    open fun play(): String = "..."
}

class Guitar : Instrument(){
    override fun play(): String = "Strum!"
}

fun task5(){
    val g = Guitar()
    println(g.play())
}

/*
Объявите интерфейс Flyable с функцией fly(distance: Int): String. Реализуйте
интерфейс в классе Plane, принимающем model (строка). Метод должен
возвращать строку вида «Boeing 737 flew 850 km». Покажите работу метода на
примере
*/

interface Flyable {
    fun fly(distance: Int): String
}

class Plane(val model: String) : Flyable{
    override fun fly(distance: Int): String{
        return "$model flew $distance km"
    }
}

fun task6(){
    val plane = Plane("Boeing 737")
    println(plane.fly(850))
}

/*
. Создайте абстрактный класс Appliance с абстрактной функцией consumption(hours:
Int): Double, возвращающей потреблённую энергию. Реализуйте подкласс Heater,
принимающий power (кВт), где consumption возвращает power × hours. Создайте
обогреватель мощностью 1,5 кВт, вычислите расход за 4 часа и выведите результат
*/

abstract class Appliance(){
    abstract fun consumption(hours: Int): Double
}

class Heater(val power: Double): Appliance(){
    override fun consumption(hours: Int): Double {
        return power * hours
    }
}

fun task7(){
    val heater = Heater(1.5)
    println(heater.consumption(4))
}

/*
Напишите функцию-расширение String.isPalindrome(): Boolean, возвращающую true,
если строка читается одинаково слева направо и справа налево, игнорируя регистр
и пробелы. Продемонстрируйте работу функции на паре строк, например «A man a
plan a canal Panama» и «Hello world»
 */

fun String.isPalindrome(): Boolean{
    val text = this.lowercase().filter { it.isLetterOrDigit() }
    return text == text.reversed()
}

fun task8(){
    println("A man a plan a canal Panama".isPalindrome())
    println("Hello world".isPalindrome())
}

/*
Создайте data-класс Laptop(model: String, price: Double, gaming: Boolean). Создайте
объект original и с помощью copy() получите discounted со сниженной ценой.
Используя деструктуризацию, получите поля второго экземпляра и выведите их
 */

data class Laptop(val model: String, val price: Double, val gaming: Boolean)

fun task9(){
    val original = Laptop("asd", 1233.4, true)
    val discounted = original.copy(price = 1233.4*0.7)

    val (model, price, gaming) = discounted
    println("Model: $model, Price: $price, Gaming: $gaming")
}

/*
Используя Pair и Triple, сохраните информацию о химическом элементе (имя,
символ) и о планете (название, расстояние от Солнца в млн км, наличие колец).
Выведите сохранённые данные в человекочитаемом виде
 */

fun task10(){
    val element = Pair("Hydro", "H")
    val planet = Triple("Earth", 400.4,  false)

    println("${element.first} это в сокращении ${element.second}")
    println("${planet.first}, ${planet.second} км до Солнца, есть ли кольца ${planet.third}")
}
/*
В связи с тем, что в прошлых файлах есть такие функции
сделаем их переопределение за счет объясвления
в них некоторых переменных
 */

/*
Определите enum class TrafficLight с константами RED(50 с), YELLOW(5 с) и GREEN(45
с). Добавьте свойство duration и метод next() — следующее состояние по циклу. В
main пройдите полный цикл дважды, каждый раз выводя состояние и его duration
 */

enum class TrafficLight(val duration: Int){
    RED(50),
    YELLOW(5),
    GREEN(45);

    fun next(): TrafficLight = when (this){
        RED -> GREEN
        GREEN -> YELLOW
        YELLOW -> RED
    }
}

fun task11(a: String = "b", b: String = "a"){
    var trafficLight = TrafficLight.RED
    repeat(6){
        println("цвет ${trafficLight.name} длится ${trafficLight.duration}")
        trafficLight = trafficLight.next()
    }
}

/*
. Создайте объект-одиночку IdGenerator с приватным счётчиком и функцией nextId():
String, возвращающей значения вида «ID-1», «ID-2», … Вызовите nextId() трижды и
выведите результаты
 */

object IdGenerator {
    private var counter = 0
    fun nextId(): String = "ID-${++counter}"
}

fun task12(a: String = "b", b: String = "a"){
    repeat(3){
        println(IdGenerator.nextId())
    }

}

fun main(){
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
    task7()
    task8()
    task9()
    task10()
    task11("a","b")
    task12("b","a")
}