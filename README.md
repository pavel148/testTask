# Определение выходных дней и нерабочего времени

## Описание

В ветке `master` расположен файл для определения выходных дней и нерабочего времени. Дабы соответствовать требованиям, данные о рабочем календаре берутся с сайта Консультант Плюс. Был реализован парсер Консультант Плюс для создания текстового календаря на указанный год.

## Как использовать

### Пример использования

При вводе даты для проверки, например, `16.08.2018`, программа скачает данные за 2018 год. Аналогично и для 2025 года. Если будет введен год, для которого нет данных (например, 2026), программа выведет ошибку.

### Формат ввода

- **Дата и время**: `дд.мм.гггг HH:mm`
- **Часовой пояс**: Необходимо вводить часовой пояс согласно требованиям:

    - `Europe/Kaliningrad`
    - `Europe/Moscow`
    - `Asia/Yekaterinburg`
    - `Asia/Omsk`
    - `Asia/Krasnoyarsk`
    - `Asia/Irkutsk`
    - `Asia/Yakutsk`
    - `Asia/Vladivostok`
    - `Asia/Magadan`
    - `Asia/Kamchatka`
    - `Asia/Sakhalin`

## Технические детали

Программа реализует парсер для получения данных с сайта Консультант Плюс и создания текстового календаря на указанный год.

Для этого задания я посчитал использование базы данных ненужным. Данные о рабочих и выходных днях легко доступны через парсер с сайта Консультант Плюс и могут быть сохранены в текстовом формате для дальнейшего использования. Это упрощает архитектуру приложения и снижает необходимость в дополнительных компонентах, таких как сервер базы данных.

Аналогично, для хранения информации о часовых поясах также не использовалась база данных. В данном задании данные о часовых поясах являются статичными и известными заранее, что позволяет хранить их непосредственно в коде.

### Пример работы программы

При запуске программы пользователь вводит дату, время и часовой пояс. Программа проверяет, является ли введенная дата и время рабочими, и выводит соответствующую информацию.

### Установка и запуск

1. Склонируйте репозиторий:
   ```sh
   git clone https://github.com/pavel148/testTask.git
