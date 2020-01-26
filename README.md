<h2>Для запуска теста:</h2> 

<ul>
<li>Настроить config.properties (указать адрес/логин/пароль к БД)</li>
<li>Файл лога пишется по умолчанию в logs/log4j-application.log  , чтобы изменить: src/test/resources/log4j.properties</li>
<li>Запустить класс <b>Lesson2</b>  <i>src > test > java > ru > otus > Tests</i></li>
</ul>

<h2>Home works 1</h2> 

<h3>Создать новый maven-проект для автоматизации тестирования</h3>

<ul>
<li>Откройте IDE</li>
<li>Создайте новый проект (maven)</li>
<li>Настройте для проекта файл .gitignore (https://www.gitignore.io/)</li>
<li>В файле pom.xml укажите зависимости для</li>
<li>Selenium Java (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)</li>
<li>WebDriverManager (https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)</li>
<li>jUnit (https://mvnrepository.com/artifact/junit/junit/4.12)</li>
</ul>

<br>

<h3>Создайте тест, который:</h3>
<ul>
<li>с помощью WebDriverManager, настраивает ChromeDriver</li>
<li>открывает в браузерах Chrome, FF (параметризодано) страницу https://otus.ru/</li>
<li>Подключить и настроить log4j</li>
</ul>

<h3>Задание со звездочкой (*)</h3>
<ul>
<li>Реализовать отображение результата прогона тестов в Grafana, используя listener (TestNG) или test rule (jUnit).</li>
<li>Подглядывать можно сюда: https://habr.com/ru/company/otus/blog/452908/</li>
<li>Использовать owner http://owner.aeonbits.org/docs/usage/</li>
</ul>



