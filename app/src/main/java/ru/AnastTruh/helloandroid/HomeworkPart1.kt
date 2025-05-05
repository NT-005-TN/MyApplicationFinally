package ru.AnastTruh.helloandroid

/*
Температурный советник
В переменной celsius хранится целое число — температура воздуха.
Выведите в консоль:
○ «Freezing», если celsius ≤ 0;
○ «Cool», если 1 ≤ celsius ≤ 15;
○ «Warm», если 16 ≤ celsius ≤ 25;
○ «Hot», если celsius > 25
*/
fun task1(celsius: Int) {
    when {
        celsius <= 0 -> println("Freezing")
        celsius in 1..15 -> println("Cool")
        celsius in 16..25 -> println("warm")
        celsius > 25 -> println("Hot")
    }
}

/*
Касса в автобусе
Пассажир сообщает свой возраст в переменной age.
Определите стоимость билета по тарифам и выведите найденную стоимость:
○ до 7 лет (включительно) — 0 ₽,
○ 8–17 лет — 15 ₽,
○ 18–60 лет — 30 ₽,
○ старше 60 лет — 20 ₽.
*/
fun task2(age: Int){
    if(age <= 7) println(0)
    else if(age in 8..17)  println(15)
    else if(age in 18..60) println(30)
    else println(20)
}

/*
Угадай сезон
В переменной month дан номер месяца (1–12).
Напечатайте название времени года на английском: «Winter», «Spring», «Summer»
или «Autumn».
*/
fun task3(month: Int){
    when(month){
        in listOf(12, 1, 2) -> println("Winter")
        in 3..5 -> println("Spring") //Java Spring Boot
        in 6..9 -> println("Summer")
        in 10..11 -> println("Winter")
    }
}

/*
Следующая буква
В переменной ch хранится одна заглавная латинская буква (A – Z). Выведите строку
«YES», если эта буква относится к гласным (A, E, I, O, U, Y), и «NO» в противном
случае.
*/
fun task4(ch: Char){
    if ("AEIOUYaeiouy".contains(ch.toString())) println("YES")
    else println("NO")
}

/*
Ряд умножения
Пользователь вводит число n (1–9).
Выведите в одной строке через пробел значения n × 1, n × 2, …, n × 10.
*/
fun task5(n: Int){
    for(i in 1..10) print(" " + n*i)
    println()
}

/*
. Города наоборот
В коде объявлен массив cities из пяти названий городов.
Выведите их по одному на строке в обратном порядке (последний → первый).
*/
fun task6(cities: List<String>){
    for(i in 4 downTo 0) println(cities[i])
}

/*
Сколько гласных?
Вводится произвольная строка text.
Посчитайте и выведите количество русских гласных букв
(«аоиеёэыуюя», регистр неважен)
*/
fun task7(text: String){
    var cnt: Int = 0
    for(ch in text) cnt += if("аоиеёэыуюяАОИЕЁЭЫУЮЯ".contains(ch)) 1 else 0
    println(cnt)
}

/*
Минимум до нуля
Есть изменяемый список целых чисел numbers: MutableList<Int>. Последний
элемент списка равен 0. Определите наименьшее значение среди всех элементов,
стоящих до этого нуля, и запишите результат в переменную minValue: Int
*/
fun task8(numbers: MutableList<Int>){
    var minValue: Int = numbers[0]
    for(x in numbers){
        if(x == 0) break
        else minValue = minOf(x, minValue)
    }
    println(minValue)
}

/*
Сумма не меньше тысячи
Дан список целых чисел data: List<Int>.
Просматривайте элементы по порядку, накапливая их сумму в переменной total:
Int, до тех пор, пока total не станет больше 1000. По завершении работы
программы в total должно находиться получившееся итоговое значение.
*/
fun task9(numbers: List<Int>){
    var total: Int = 0
    for(x in numbers){
        total += x
        if(total > 1000) break
    }
    println(total)
}

/*
. Ближайшая степень двойки
Задано натуральное число k: Int. Найдите наименьшую степень двойки 2^m,
которая не меньше k, и сохраните это значение в переменной closestPower: Int.
Число m выводить или сохранять не требуется.

*/
fun task10(k: Int){
    var closetPower: Int = 0
    var number: Int = k
    while(number > 0){
        closetPower += 1
        number /= 2
    }
    println(closetPower)
}

/*
1. Безопасная длина отчества
В коде уже объявлена переменная middleName: String? = null.
Напечатайте строку вида «Количество символов = X»,
где X — длина middleName, если значение не null,
или 0, если переменная равна null.
*/

fun task11(){
    var middleName: String? = null
    if (!middleName.isNullOrEmpty()) println(middleName.length)
    else println(0)
}

fun main(){
    task1(12)
    task2(40)
    task3(2)
    task4('B')
    task5(6)
    task6(listOf("A","b","a","C","d"))
    task7("АБВБАБВАБВЛОАШТфыбвфаьвыто")
    task8(mutableListOf(4,2,5,2,5,7,2,6,1,3,5,0))
    task9(listOf(123,123,12,543,2,5,123,2))
    task10(7)
    task11()

}