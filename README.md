<div align="center" style="text-align:center">
<br>

# Imgur App

<p> A simple android app written in Kotlin to search and view top weekly images from the Imgur API.<br></p>

---

</div>

## Imgur App
An Android App for searching and viewing top weekly images from the imgur API, the application is built to show the use of MVVM clean architecture along with different architecture components in Android along with best practices. Read more about MVVM Clean architecture [here](https://developer.android.com/topic/architecture)

## **Problem Statement**

Design an application that searches for the top images of the week from the Imgur gallery and displays them in a list. The app should have a layout toggle feature. The users should be able to switch between 'List' and 'Grid' layout with the help of a button click.

## **Solution**

Using <b>MVVM  Clean architecture, ViewModel, LiveData, Coroutines</b> and many of the <b>Jetpack Libraries</b>, we have built this app that lets you search for the top images of the week from the imgur gallery and view in a list of grid layout along with a few other details.

## **Steps to run the app**

You are requested to fork the project and then clone the forked project to your local device. Run the cloned repository with the help of Android Studio, <b>[Important]</b> The gradle is supposed to <b>fail</b> since the value of the ``CLIENT_ID`` is not found. You should head to [Imgur API docs](https://apidocs.imgur.com/) and follow the steps or head down to [app registeration](https://api.imgur.com/oauth2/addclient) to register your application and generate your ``CLIENT_ID`` and ``CLIENT_SECRET``. Replace the ``CLIENT_ID`` with your generated client id and run the application.

Please find also a ``app-debug.apk`` attached in the repo. You can go ahead download the APK and get started immediately. [Please note the support for the APK might end soon. In case the downloaded APK doesn't work or if you're unable to see data with the downloaded APK, you are suggested to follow the steps above].

## **Functionality & Concepts used**

The App has a very simple and interactive design which helps user quicly look for any pictures from the imgur gallery have them  according viewed according to their layout preference(list or grid).
Following are few android concepts used to achieve the functionalities in app :

- `Imgur API` : The Imgur API is used for fetching the data from the remote server and serve it to the user using the Imgur application.
- `Constraint Layout` : All of the activities in the app uses a flexible <b>Constraint Layout</b>, which is easy to handle for different screen sizes.
- `Recyclerview` :  To present the list of different images we used the efficient <b>Recyclerview</b>. 
- `LiveData` : We are also using <b>LiveData</b> to update & observe any changes to the response we receive from the Imgur API
- `Navigation Component` : We are also using the <b>Navigation component</b> to switch pages/destination within the app.
- `Retrofit` : Used retrofit for making HTTPS requests to the Imgur API.
- `Glide` : Made use of Glide to load image url into image resources for the view of the recycler view.
- `Dagger Hilt` : Made use of Dagger Hilt for dependency injection. Dependency injection has been implemented into the project keeping in mind future aspects of the project related to scalibility and easier testing.

## **Screenshots**
### **Light(List)**
<img width="200" height="433" src="./assets/images/ss5_light.jpg"> <img width="200" height="433" src="./assets/images/ss2_light.jpg">

### **Light(Grid)**
<img width="200" height="433" src="./assets/images/ss4_dark.jpg"> <img width="200" height="433" src="./assets/images/ss1_light.jpg">

### **Dark(List)**
<img width="200" height="433" src="./assets/images/ss3_dark.jpg"> <img width="200" height="433" src="./assets/images/ss2_dark.jpg"> 
### **Dark(grid)**
<img width="200" height="433" src="./assets/images/ss5_dark.jpg"> <img width="200" height="433" src="./assets/images/ss1_dark.jpg"> 
## **Application Link & Future Scope**

The app is currently in the development phase. We plan to bring more features in the future which would make the app more interactive. You can access the `app by cloning the repo and replacing the ``CLIENT_ID`` with your client id(Please find the instructions above).
Also we welcome, anyone who has an idea or wants to contribute to the project or just refer to the project.

### Thank You!! :)
