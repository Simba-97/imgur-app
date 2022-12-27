<div align="center" style="text-align:center">
<br>

# Imgur App

<p> A simple android app written in Kotlin to search and view top weekly images from the Imgur API.<br></p>

---

</div>

## Imgur App
An Android App for search and viewing top weekly images from the imgur API, the application is built to show the use of MVVM clean architecture along with different architecture components in Android along with best practices.

## **Problem Statement**

Design an application that searches for the top images of the week from the Imgur gallery and displays them in a list. The app should have a layout toggle feature. The users should be able to switch between 'List' and 'Grid' layout with the help of a button click.

## **Solution**

Using <b>MVVM  Clean architecture, ViewModel, LiveData, Coroutines</b> and many of the <b>Jetpack Libraries</b>, we have built this app that lets you search for the top images of the week from the imgur gallery and view in a list of grid layout along with a few other details.

## **Functionality & Concepts used**

The App has a very simple and interactive design which helps user quicly look for any pictures from the imgur gallery have them  according viewed according to their layout preference(list or grid).
Following are few android concepts used to achieve the functionalities in app :

- `Imgur API` : The Imgur API is used for fetching the data from the remote server and serve it to the user using the Imgur application.
- `Constraint Layout` : All of the activities in the app uses a flexible <b>Constraint Layout</b>, which is easy to handle for different screen sizes.
- `Recyclerview` :  To present the list of different images we used the efficient <b>Recyclerview</b>. 
- `LiveData` : We are also using <b>LiveData</b> to update & observe any changes to the response we receive from the Imgur API
- `Navigation Component` : We are also using the <b>Navigation component</b> to switch pages/destination within the app.

## **Screenshots**
### **Light**
<img width="200" height="433" src="./assets/images/ss1_light.jpg"> <img width="200" height="433" src="./assets/images/ss2_light.jpg"> <img width="200" height="433" src="./assets/images/ss3_light.jpg"><img width="200" height="433" src="./assets/images/ss4_dark.jpg">
<img width="200" height="433" src="./assets/images/ss5_light.jpg"> 
### **Dark**
<img width="200" height="433" src="./assets/images/ss1_dark.jpg"> <img width="200" height="433" src="./assets/images/ss2_dark.jpg"> <img width="200" height="433" src="./assets/images/ss3_dark.jpg"> <img width="200" height="433" src="./assets/images/ss5_dark.jpg">

## **Application Link & Future Scope**

The app is currently in the development phase. We plan to bring more features in the future which would make the app more interactive. You can access the `app by cloning the repo and replacing the ``CLIENT_ID``` with your client id(Please find the instructions above).
Also we welcome, anyone who has an idea or wants to contribute to the project or just refer to the project.

### Thank You!! :)
