#  📌  Spring-boot Employee Management Web App

#### Это веб-приложение на Java, созданное с помощью Spring Boot для управления информацией о сотрудниках. Оно предоставляет функциональные возможности для выполнения CRUD-операций с данными сотрудников, хранящимися в базе данных MySQL.

## ⚙️ Setting Up

### 🐳 Docker
> [!NOTE]<br>
> Для запуска проекта используется Docker<br>

Используется база данных - mysql<br>
Для запуска скрипта используется команда - docker compose up

```dockerfile
version: '3.1'
services:
  db:
    image: mysql
    restart: always
    environment:
      MYSQL_USER: root
      MYSQL_PASSWORD: root
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: management-systems
    ports:
      - "3308:3306"
  phpmyadmin:
    image: phpmyadmin/phpmyadmin:latest
    restart: always
    environment:
      PMA_HOST: db
      PMA_USER: root
      PMA_PASSWORD: root
    ports:
      - "8080:80"
```
### 🌐 SQL Scripts

#### 01-create-table.sql
 - Этот скрипт содержит SQL-команды для создания необходимых таблиц для хранения информации о сотрудниках в базе данных.

#### 02-add-data.sql
- Этот скрипт содержит SQL-команды для добавления исходных данных в таблицы, созданные с помощью 01-create-table.sql.
- Базовый пароль всех пользователей - `test` - используя шифрование bcrypt

## ‍💻 Используемые технологии
- Spring Boot: Фреймворк для создания веб-приложений на языке Java.
- Spring Boot Data JPA: Зависимость для работы с JPA (Java Persistence API) в Spring Boot.
- Spring Boot Security: Зависимость для включения механизмов безопасности в приложение.
- Spring Boot Thymeleaf: Зависимость для использования Thymeleaf в качестве шаблонизатора.
- Spring Boot Web: Зависимость для создания веб-приложений с использованием Spring MVC.
- Thymeleaf Extras SpringSecurity6: Дополнительные библиотеки Thymeleaf для интеграции с Spring Security версии 6.

## ✉️ Отправка сообщений
- Для окончательной настройки необходимо создать файл application.properties (в качестве примера представлен файл application.properties-example)
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL
spring.mail.password=GMAIL_PROGRAM_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
## 🚀 Запуск проекта
```
$ mvn spring-boot:run
```

## 👩‍💻 Controllers
- EmployeeController: Обрабатывает запросы, связанные с управлением информацией о сотрудниках, такие как просмотр, добавление, обновление и удаление.
- MainController: Обрабатывает запросы, связанные с основной логикой приложения, такие как вход в систему.
- UserRegistrationController: Обрабатывает запросы, связанные с регистрацией новых пользователей в системе.

## 🛡️ Security Config
- DaoAuthenticationProvider: Этот бин предоставляет механизм аутентификации для Spring Security, используя сервис пользователя (UserService) для получения информации о пользователе и BCryptPasswordEncoder для проверки пароля.
- filterChain: Этот бин настраивает цепочку фильтров безопасности для HTTP запросов. В данном случае, он указывает, что запросы к определенным ресурсам, таким как регистрация, статические ресурсы (js, css, img) должны быть разрешены всем, в то время как для всех остальных запросов требуется аутентификация.
- authorizeHttpRequests: Этот метод настраивает правила авторизации. В данном случае, запросы к определенным URL-адресам разрешены всем (permitAll()), в то время как для всех остальных запросов требуется аутентификация (authenticated()).
- formLogin: Этот метод настраивает страницу входа (loginPage), которая будет использоваться для аутентификации пользователей. Также указывается, что доступ к этой странице разрешен всем (permitAll()).
- logout: Этот метод настраивает параметры выхода из системы, такие как инвалидация сеанса (invalidateHttpSession), очистка аутентификации (clearAuthentication), URL для перенаправления после выхода из системы (logoutSuccessUrl). Также указывается, что доступ к этой функции разрешен всем (permitAll()).

## 📤 DTO - UserRegistrationDTO
- Этот код представляет простой Java класс для передачи данных (Data Transfer Object, DTO) для регистрации пользователей в системе. 

## 💻 Services
### 👨‍💼 EmployeeServiceImpl:
- getAllEmployees(): Метод для получения списка всех сотрудников из репозитория. Он вызывает метод findAll() из репозитория, который возвращает список всех сотрудников.
- saveEmployee(Employee employee): Метод для сохранения сотрудника в репозитории. Принимает объект сотрудника и использует метод save() репозитория для сохранения его.
- getEmployeeById(long id): Метод для получения сотрудника по его идентификатору. Он вызывает метод findById() репозитория и возвращает найденного сотрудника или бросает исключение, если сотрудник не найден.
- deleteEmployeeById(long id): Метод для удаления сотрудника по его идентификатору. Он вызывает метод deleteById() репозитория для удаления сотрудника.
- findPaginated(int pageNo, int pageSize, String sortField, String sortDirection): Метод для поиска сотрудников с пагинацией. Принимает номер страницы, размер страницы, поле сортировки и направление сортировки. Он создает объект Pageable с заданными параметрами и использует метод findAll() репозитория для поиска сотрудников с пагинацией и сортировкой.
### 🧑🏻‍💻 UserServiceImpl:
- save(UserRegistrationDto registrationDto): Метод для сохранения пользователя. Принимает объект DTO для регистрации пользователя, шифрует его пароль с помощью BCryptPasswordEncoder, создает объект пользователя с ролями по умолчанию ("ROLE_USER") и сохраняет его в репозитории.
- loadUserByUsername(String username): Метод для аутентификации пользователя. Принимает имя пользователя и ищет пользователя по его адресу электронной почты в репозитории. Если пользователь не найден, выбрасывается исключение. Затем создается объект UserDetails с помощью Spring Security и возвращается.
- mapRolesToAuthorities(Collection<Role> roles): Приватный метод для преобразования ролей пользователя в коллекцию объектов GrantedAuthority, которые используются в Spring Security для представления разрешений пользователя.

## 🎯 Goals 
- Доработка функционала работы с записями пользователя (обновление, изменение и добавление ролей
- Перевод на микросервсиную архитектуру