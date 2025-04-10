# Client-Server Application

## 📌 Описание проекта

Данный проект представляет собой учебное клиент-серверное приложение на Java, разработанное в рамках лабораторных работ (№5–8). Он демонстрирует основные принципы клиент-серверного взаимодействия, сериализации данных, работы с потоками, а также обработки команд и взаимодействия с базой данных.

Проект разбит на три модуля:

- **Client** — отвечает за взаимодействие с пользователем.
- **Server** — обрабатывает команды и работает с базой данных.
- **General** — содержит общие классы и структуры, используемые обеими сторонами.

## ⚙️ Используемые технологии

- **Java 17+**
- **Gradle** — система сборки
- **Socket API** — взаимодействие клиент-сервер
- **Сериализация/десериализация** — передача объектов
- **PostgreSQL**
- **Многопоточность** на стороне сервера

## 🚀 Основной функционал

### Клиент:
- Подключение к серверу
- Отправка команд и аргументов
- Получение и вывод результата
- Выполнение скриптов с командами (в т.ч. рекурсивно)
- Валидация пользовательского ввода

### Сервер:
- Обработка команд от клиентов
- Ведение состояния
- Работа с базой данных
- Многопоточная обработка подключений
- Аутентификация пользователей (если реализовано)

### Общий модуль:
- Команды (Command, CommandResult)
- Классы DTO (Data Transfer Objects)
- Утилиты и вспомогательные классы

## 📂 Команды (примерный список)

- `add {element}` — добавить элемент
- `update {id} {element}` — обновить по ID
- `remove {id}` — удалить по ID
- `execute_script {file}` — выполнение скрипта
- `info` — информация о коллекции
- `help` — список команд
- `exit` — завершение работы клиента

Баянов Равиль - @RavvChek
