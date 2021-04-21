# Name:
Ing-application: login;
## Introduction
Bun venit!
Aici gasiti aplicatia de autentificare a unui utilizator.

## Presentation
    Ing_App este o aplicatie simpla, creata in scopul autentificarii pe o pagina web. Ruland aplicatia aveti posibilitatea de a va autentifica printr-un formular de login daca aveti deja un cont creat sau sa va creati un cont de utilizator prin formularul de inregistrare(Register")

    Odata creat contul, va puteti loga, urmand sa fiti redirectionati catre o pagina Index care va afiseaza, la cerere, un tabel cu toti utilizatorii creati de Dvs. 
    
    De asemenea aveti posibiliatatea de a va deloga(de a iesi din aplicatie) accesand butonul de "Logout".

    Aplicatia a fost creata in Inteliji folosig Spring Boot Security.
    Link catre aplicatie: https://github.com/Andreea-Macovei1705/Job_Ing.git.

## Requirements:
"Create a Java project that performs user authentication

- Create a Github profile if you don't have one;
- Create a Java, maven based project, Springboot for the web part;
- Use git in a verbose manner, push even if you wrote only one class;
- Keep it simple (5-6 classes), no front-end, you can focus on backend;
- Basic functions, like login, logout (bonus: see user details, it can be something like name, age etc.);
- Implement error mechanisms and handling plus logging;
- Write unit tests, at least for one class, preferably the 'trickiest' class;
- Use Java 8 features;
- Add a small Readme to document the project."

## Methodology:
-> Crearea aplicatiei am realizat-o utilizand Spring Initializr (https://start.spring.io/) adaugand dependinte in pom.xml pentru: 
* Spring Boot Application
* Spring Security
* Spring Data JPA
* Spring Web
* Thymleaf
* SQL DB
* Testing

-> Proiectul a fost realizat dupa arhitectura MVC(Model- View- Controller), astfel ca structura este formata din urmatoarele pachetele si clasele aferente:
    - config (UserSecurityConfig);
    - contrlollers (UserControllers);
    - entities (UserEntity)
    - exceptions (InvalidDivizorException, InvalidNameException);
    - repositories (UserRepository);
    - services (UserService);
    - clasa de rulare JobApplication;
    - resources ( templates( index.html, login.html, refister.html), application.properties (datele de conectare caatre baza de date creata in MySQLWorkbench));
    - test(JobApplicationTests).

 Rularea aplicatiei Ing_app:
    Rularea aplicatiei se face din clasa JobApplication si se deschide in browser astfel: http://localhost:8080/login. 

    Daca este prima rulare este necesara inregistrarea unui utilizator accesand butonul Register(prin campurile: Username, Password, Age, Address (http://localhost:8080/register)), urmand sa fiti redirectionati catre formularul de login.

    Dupa introducerea datelor de login(Username si Password) sunteti directionati catre pagina Index (http://localhost:8080/) care contine un cap de tabel si un buton care permite, prin accesarea lui, sa vizualizati lista tuturor utilizatorilor inregistrati de Dvs.,impreuna cu toate datale de inregistrare, mai putin parola (http://localhost:8080/login/getusers).
    Din pagina de Index puteti accesa butonul de Login pentru a parasi pagina (http://localhost:8080/login?logout).

    Toate metodele de control sunt create in UserConttroller si prin intermediul UserService, UserRepository sunt utilizate in paginile html create.

    Partea de implementare a erorii am folosit-o pe clasa UserService prin metoda getUsername. Astfel am tratat exceptia in care username-ul introdus este null.
    Tesatarea a fost facuta tot pe clasa de UserService cu rezultatul: test trecut. 

# Further reading

## Books
1. Java de la  la expert, Stefan Tanasa, Cristian Olaru, Stefan Andrei

## Links
1. https://www.w3schools.com/
2. https://start.spring.io/
3. https://getbootstrap.com/
4. https://www.geeksforgeeks.org/


