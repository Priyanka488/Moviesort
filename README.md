# Moviesort
<b> MOVIESORT </b>

<b> Moviesort is an android Java application that sorts movies based on fields like "Upcoming movies","Latest Movies","Popular Movies" and "Top rated movies" and displays the list to the user.</b>

It uses the API by The Movie Database (moviedb).
The app covers the following android concepts :

1. API Integration
2. JSON Parsing
3. Creation of Background threads using AsyncTask Loaders
4. Displaying the results using Recycler view
5. Passing of data through intents

The app inputs one of the categories by the user (through the spinner).On pressing the "Go" button , a new activity is displayed containing the list of relevant movies.

<b> Screenshots of the app :</b>

<div align="center">
    <img src="/screenshots/1.jpeg" width="400px"</img> 
</div>

<div align="center">
    <img src="/screenshots/2.jpeg" width="400px"</img> 
</div>

<div align="center">
    <img src="/screenshots/3.jpeg" width="400px"</img> 
</div>


To run this project , download / clone the project and run in Android Studio.

<b> Note:</b> To run the app , get you own API key from https://developers.themoviedb.org/3 , and enter it in NetworkUtils class , present in utilities folder.