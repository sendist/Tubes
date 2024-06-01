
# 3B-Kelompok 5 - Web Automation Testing untuk Aplikasi Swag Labs dengan Cucumber dan Selenium

Projek automation testing untuk menguji fungsionalitas login dan logout dari tautan (https://www.saucedemo.com/). Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan Maven (build management)


## Build With

Proyek pengujian otomatis melibatkan library:
- Cucumber
- JUnit
- Selenium

## Prerequisite

Sebelum menjalankan proyek ini, diperluan persyaratan environtmen yang harus disiapkan pada device eksekusi proyek
- JDK diatas versi 8
- Code Editor, disarankan VS Code
- Maven

## Instalation
Proses instalasi proyek ini pada local environment

- Clone repo ini dengan perintah:
```bash
git clone https://github.com/sendist/automated-testing-web.git
```
- Masuk ke folder project: 
```bash
cd automated-testing-web
```
- Buka Code Editor, Misalnya VS code

## Project folder structure

```bash
/src
|-- /test
|   |-- /java
|   |   |-- /actions
|   |   |   |-- HomePageActions.java
|   |   |   |-- LoginPageActions.java
|   |   |-- /locators
|   |   |   |-- HomePageLocators.java
|   |   |   |-- LoginPageLocators.java
|   |   |-- /runner
|   |   |   |-- CucumberRunnerTest.java
|   |   |-- /stepdefinitions
|   |   |   |-- Hooks.java
|   |   |   |-- LoginSteps.java
|   |   |   |-- LogoutSteps.java
|   |   |-- /utils
|   |   |   |-- HelperClass.java
|   |-- /resources
|   |   |-- LoginPage.feature
|   |   |-- LogoutPage.feature
```

## How to Run Execution Testing

### Terminal
Proses menjalankan eksekusi testing melalui terminal dengan menjalankan kode berikut:
```bash
  mvn test 
```

## How to see test report
Setelah melakukan test execution, buka file html berikut pada browser:
```bash
/target
|-- /HtmlReports
|   | -- report.html
```

## Authors
Kami kelompok B5 dari kelas 3B-D4 Teknik Informatika Politeknik Negeri Bandung
- Muhammad Daffa Raihandika (211524050) (username github: [daffaraihandika](https://github.com/daffaraihandika))
- Reza Ananta Permadi Supriyo (211524059) (username github: [rzanta](https://github.com/rzanta))
- Sendi Setiawan (211524062) (username github: [sendist](https://github.com/sendist))

## Reference
Daftar resource
- [Swag Labs](https://www.saucedemo.com)