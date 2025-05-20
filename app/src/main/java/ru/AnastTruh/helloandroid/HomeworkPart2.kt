package ru.AnastTruh.helloandroid

/*
Напишите функцию welcomeBot(id: String), которая выводит строку
Beep! Unit <id> online
 */

//тут происходит переопределение функции в связи с тем, что просто task11() конфликтует с фалом прошлой ДЗ, где тоже есть task11()
fun task11(id: String = "2"){
    fun welcomeBot(id: String) =
        println("Beep! Unit $id online")
    welcomeBot(id)
    //Записано согласно ТЗ, но вероятно стоило вызвать просто функцию в main
    //кстати такая функция уже по идее что-то наподобие локальной функции до которой нельзя добраться вне функции task11
}

/*
Создайте функцию orderPaint(color: String = "silver", layers: Int = 1), печатающую
строку
Painting robot in <color> (layers: <layers>).
Если аргументы не переданы — используются значения по умолчанию.
Если layers ≤ 0, функция должна вывести сообщение об ошибке "Invalid number of
layers"

 */

fun task12(){
    fun orderPaint(color: String = "silver", layers: Int = 1) =
        if(layers > 0)
            println("Painting robot in $color (layers $layers)")
        else
            println("Invalid number of layers")
    orderPaint()
}

/*
Объявите компактную функцию triple(x: Int): Int = x * 3.
Затем реализуйте функцию sumOfTriples(n: Int): Int, которая для каждого i из
диапазона 1..n вызывает triple(i) и выводит полученную сумму
 */

fun task13(){
    fun triple(x: Int): Int = x * 3
    fun sumOfTriples(n: Int) = println((1..n).sumOf{triple(it)})

    sumOfTriples(5)
}

/*
4. Объявите переменную boost: (Int) -> Int, которая для чётных аргументов
возвращает их куб, для нечётных — квадрат; если модуль результата превышает
1_000_000, вместо числа выводится сообщение об ошибке "Out of range";
продемонстрируйте работу, вызвав boost(4) и выведя полученный результат
 */

fun task14(){
    val boost: (Int) -> Any = {
        val res = if(it % 2 == 0) it*it*it else it*it
        if(Math.abs(res) > 1_000_000) "Out of range" else res
    }
    println(boost(5))
}

/*
5. Реализуйте функцию combine(a: Int, b: Int, operation: (Int, Int) -> Int): Int, которая
применяет переданную в параметре operation функцию к значениям a и b, если оба
числа положительные, иначе возвращает результат применения функции operation
к их модулям, и выведите результат

 */

fun task15(){
    fun combine(a: Int, b: Int, operation: (Int, Int) -> Int): Int =
        if(a > 0 && b > 0) operation(a,b) else operation(Math.abs(a), Math.abs(b))
    val multiply: (Int, Int) -> Int = {a, b -> a*b}
    println(combine(55,5, multiply))
}

/*
. Создайте функцию wrapInHashes(text: String): String, добавляющую по одному
символу # в начало и конец строки. Передайте её как ссылку ::wrapInHashes вторым
аргументом в функцию secureText, которая должна вызвать полученную функцию и
вывести преобразованный текст
 */

fun task16(){
    fun wrapInHashes(text: String): String = "#$text#"
    fun secureText(text: String, transform: (String) -> String) = wrapInHashes(text)

    println(secureText("someText", ::wrapInHashes))
}

/*
7. В коде объявлен список drones, например listOf("AX23X", "BT77", "QX90X"),
отфильтруйте элементы, оставив только те, что оканчиваются символом 'X' и при
этом содержат не менее пяти символов, затем преобразуйте их в нижний регистр и
выведите получившийся список
 */

fun task17(){
    val drones = listOf("AX23X", "BT77", "QX90X").filter{ it.endsWith("X") && it.length >= 5 }.map(String::lowercase)
    println(drones)
}

/*
8. Напишите функцию computeFibonacci(n: Int?): Int?, которая возвращает n-е число
Фибоначчи, если n не равен null и неотрицательно, при этом для значений n от 0 до
1 возвращается n, а для остальных — рекурсивно вычисляется сумма двух
предыдущих чисел; если n меньше 0 или равно null, функция должна вернуть null,
выведите результаты для нескольких значений n, включая null и отрицательные
числа
 */

fun task18() {
    fun computeFibonacci(n: Int?): Int? {
        if (n == null || n < 0) return null
        if (n <= 1) return n

        val a = computeFibonacci(n - 1)
        val b = computeFibonacci(n - 2)

        return if (a != null && b != null) a + b else null
    }

    println(computeFibonacci(9))
}


/*
9. Создайте функцию findMinCharge(levels: List<Int>?): Int?, которая возвращает
минимальный уровень заряда батарей из переданного списка, при этом функция
должна игнорировать все отрицательные значения и возвращать null, если список
равен null, пустой или не содержит ни одного положительного значения; выведите
результат для примера с положительными, отрицательными и нулевыми
значениями
 */

fun task19(){
    fun findMinCharge(levels: List<Int?>?): Int?{
        if(levels != null){
            var res = levels?.filterNotNull()
                res = res?.filter{ it > 0 }
                if (res?.minOrNull() != null) return res?.minOrNull()
                else return null
        } else {
            return null
        }
    }
    var lst = emptyList<Int>()
    println(findMinCharge(lst))
    println(findMinCharge(listOf(-1,-1,-3,-32)))
    println(findMinCharge(listOf(1,2,5,-2,-4,null,2,5,-2,5,13,53,23,-32)))
}
/*
10. Реализуйте функцию sumValid(values: List<Int?>): Int, которая суммирует все
элементы списка, игнорируя значения null и те, что меньше нуля, и выводит
итоговое значение суммы только положительных чисел
 */

fun task20(){
    fun sumValid(values: List<Int?>): Int {
        var res = values.filter{ it != null && it > 0 }
        return(res.filterNotNull().sum())
    }
    println(sumValid(listOf(1,2,5,null,-2,-4,-2,0,2)))
}

/*
11. Напишите функцию adjustSignals(signals: List<Int>, adjust: (Int) -> Int = { it * 2 }):
List<Int>, которая применяет к каждому элементу списка signals функцию adjust (по
умолчанию — удвоение), исключая из обработки отрицательные значения, и
возвращает новый список преобразованных положительных чисел; проверьте
работу функции как с преобразованием по умолчанию, так и с передачей лямбды,
умножающей элемент на 10
 */

fun task21(){
    fun adjustSingals(single: List<Int>, adjust: (Int) -> Int = { it * 2 }): List<Int> {
        return(single.filter{it > 0}.map(adjust))
    }
    println(adjustSingals(listOf(2,4,1,2,5,10,-2,23,-2,-2)))
    println(adjustSingals(listOf(2,4,1,2,5,10,-2,23,-2,-2), { it * 10 }))
}

fun main(){
    task11()
    task12()
    task13()
    task14()
    task15()
    task16()
    task17()
    task18()
    task19()
    task20()
    task21()
}