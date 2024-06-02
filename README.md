
# 3B-Kelompok 5 - Automation Testing untuk Aplikasi Swag Labs dan API Testing untuk Dummy API dengan Cucumber, Selenium, dan Rest Assured

Proyek automation testing untuk menguji fungsionalitas aplikasi dari tautan (https://www.saucedemo.com/) dan API Testing untuk menguji Dummy API dari tautan (https://dummyapi.io/). Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan Maven (build management)


## Build With

Proyek pengujian otomatis melibatkan library:
- Cucumber
- JUnit
- Selenium
- Rest Assured

## Prerequisite

Sebelum menjalankan proyek ini, diperluan persyaratan environtmen yang harus disiapkan pada device eksekusi proyek
- JDK diatas versi 8
- Code Editor, disarankan VS Code
- Maven

## Instalation
Proses instalasi proyek ini pada local environment

- Clone repo ini dengan perintah:
```bash
git clone https://github.com/sendist/automation-testing-api-and-web.git
```
- Masuk ke folder project: 
```bash
cd automated-testing-api-and-web
```
- Buka Code Editor, Misalnya VS code

## Project folder structure

```bash
├───src
│   └───test
│       ├───java
│       │   ├───actions
│       │   │       CartPageActions.java
│       │   │       CheckoutPageActions.java
│       │   │       HomePageActions.java
│       │   │       LoginPageActions.java
│       │   │       ProductDetailPageActions.java
│       │   │
│       │   ├───locators
│       │   │       CartPageLocators.java
│       │   │       CheckoutPageLocators.java
│       │   │       HomePageLocators.java
│       │   │       LoginPageLocators.java
│       │   │       ProductDetailPageLocators.java
│       │   │
│       │   ├───runner
│       │   │       CucumberRunnerTest.java
│       │   │
│       │   ├───stepdefinitions
│       │   │   │   Hooks.java
│       │   │   │
│       │   │   ├───APITesting
│       │   │   │       CreateUserSteps.java
│       │   │   │       DeleteUserSteps.java
│       │   │   │       GetUserSteps.java
│       │   │   │       UpdateUserSteps.java
│       │   │   │
│       │   │   └───WebTesting
│       │   │           CartSteps.java
│       │   │           CheckoutSteps.java
│       │   │           DashboardSteps.java
│       │   │           EndSteps.java
│       │   │           LoginSteps.java
│       │   │           LogoutSteps.java
│       │   │           MenuSteps.java
│       │   │           ProductDetailSteps.java
│       │   │
│       │   └───utils
│       │           HelperClass.java
│       │
│       └───resources
│           ├───APITesting
│           │       CreateUser.feature
│           │       DeleteUser.feature
│           │       GetUser.feature
│           │       UpdateUser.feature
│           │
│           └───WebTesting
│                   Cart.feature
│                   Checkout.feature
│                   Dashboard.feature
│                   EndToEnd.feature
│                   LoginPage.feature
│                   LogoutPage.feature
│                   Menu.feature
│                   ProductDetail.feature
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
- [Dummy API](https://dummyapi.io/)