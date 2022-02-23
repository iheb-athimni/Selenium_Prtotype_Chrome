# Cucumber_Test_Basics
Front test automation Project prototype 

This is Java project for test automation, covering simple login test case . Created with Page Object Module design to provide best practices required to create test automation project artifacts . The framework was first introduced on selenium-maven-test-automation-project.

Concepts Included
* test runs
* Shared state across cucumber step definitions
* Dependency injection
* Page Object pattern
* web page handle methods
* Externalised test configuration
* Commonly used test utility classes
* Simple git deployment Action

Tools
* Maven
* Cucumber-JVM
* JUnit
* Spring
* Selenium Webdriver
* GitHUb Action

Requirements
In order to utilise this project you need to have the following installed locally:
* Maven installed 
* Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
* Java 1.8

Usage
The project has a main modules UI testing.this  module can be used with maven profiles.

To run this UI project, navigate to Front_test_chrome and run:
mvn clean install

Reporting
Reports for each module are written as .html file into their respective /target directories after a successful run.

NOTE: 
I m working on the report part and the sending report As i mentioned, cucumber reports will be written in simple html file 

Hope you enjoy 🙂.
