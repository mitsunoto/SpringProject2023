# SpringProject2023

Используемые инструменты: Spring, PostgreSQL, JPA.

Данный проект разрабатывался в рамках дисциплины "Разработка Приложений в Распределенной среде".

## База данных
База данных, хранящаяся в PostgreSQL:
![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/b0a15937-e7de-4c7f-bc3c-ff725be21dd4)

## HTTP-запросы
Для тестирования HTTP-запросов можно использовать приложение Postman:
### 1) Добавление новой записи. 
  Для этого, помимо самого HTTP-запроса, необходимо также прописать текст в формате JSON со всеми полями. <br/>
  ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/995f09e3-6a14-4544-acdc-cb46af946177)

  Удостоверимся, что запись действительно появилась в БД: (8 строка)
  ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/da50fd45-ff97-4160-a846-6a5632f96393)

### 2) Получение существующей записи. 
  В качестве результата будет получен текст в формате JSON.
  ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/a21b9795-4cee-415b-b147-dc0256d4fa5d)

### 3) Изменение существующей записи.
   Аналогично созданию новой записи, кроме HTTP-запроса, необходимо указать JSON текст с полями, которые необходимо изменить.
   ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/8068abc6-394d-46ed-95f2-e9f08bf385cd)

   Проверяем БД. Номер телефона в строке 8 действительно поменялся на "777".
   ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/317eba41-87cf-426e-ac3d-8b1384c87d5e)

### 4) Удаление записи.
   ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/cc11a806-fe2b-4362-a2c8-57495fe5582c)

   8 строка успешно удалена.
   ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/d7594788-8570-485b-b3d1-500fcca8bdd5)

### 5) Получение конфигурации.
  В данном случае обращение выполняется к другому порту. Это объясняется тем, что сервер конфигураций запускается 
  отдельно от основного приложения.
  ![image](https://github.com/mitsunoto/SpringProject2023/assets/129619597/024e9c33-18b7-40b3-b0bc-35a6089e256d)
