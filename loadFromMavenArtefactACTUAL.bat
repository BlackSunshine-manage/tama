goto start
--------------------------------------
====Файл запуска приложения==========
--------------------------------------
Мавен-артефакт по пути "\tama\target" название артефакта во время выполнения: "tama-1.0-SNAPSHOT-jar-with-dependencies.jar"
Требования к работе: 
1.Java 8+ (запускалось на 14)
2.JFXlibs 16+1(Версия библиотек)
В "path_to_artefact" - указать полный путь к артефакту(без ковычек)
В "path_to_jfxlibs" - указать полный путь к библиотекам javafx 16+(без ковычек)

:start

cd "path_to_artefact"
java --module-path "path_to_jfxlibs" --add-modules=javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.web --add-exports javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED -jar tama-1.0-SNAPSHOT-jar-with-dependencies.jar
