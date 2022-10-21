module demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires com.fasterxml.jackson.annotation;
    requires java.xml;
    requires spring.data.jpa;
    requires java.net.http;
    requires com.github.underscore;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo.GUI;

}