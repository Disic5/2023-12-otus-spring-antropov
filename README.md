Домашнее задание
Приложение по проведению тестирования студентов - только вывод вопросов и вариантов ответа (если имеются)

Цель:
Создать приложение с помощью Spring IoC, чтобы познакомиться с основной функциональностью IoC, на которой строится весь Spring.
Результат: простое приложение, сконфигурированное XML-контекстом.


Описание/Пошаговая инструкция выполнения домашнего задания:
Описание задания:
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
Приложение должна просто вывести вопросы теста из CSV-файла с возможными вариантами ответа (если имеются).


Требования:
0. В приложении должна присутствовать объектная модель (отдаём предпочтение объектам и классам, а не строчкам и массивам/спискам строчек).

Все классы в приложении должны решать строго определённую задачу (см. п. 18-19 "Правила оформления кода.pdf", прикреплённые к материалам занятия).
Контекст описывается XML-файлом.
Все зависимости должны быть настроены в IoC контейнере.
Имя ресурса с вопросами (CSV-файла) необходимо захардкодить строчкой в XML-файле с контекстом.
CSV с вопросами читается именно как ресурс, а не как файл.
Scanner, PrintStream и другие стандартные типы в контекст класть не нужно!
Весь ввод-вывод осуществляется на английском языке.
Крайне желательно написать юнит-тест какого-нибудь сервиса (оцениваться будет только попытка написать тест).
Помним - "без фанатизма".
