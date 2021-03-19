# Auto Schedule Generator

<img src="https://upload.wikimedia.org/wikipedia/en/0/07/Ala-Too_International_University_Seal.png" width="20%" />

## Author: Fatima Bekmamatova COM19-A

### This site for the autogenerating schedule at universities
![](https://github.com/Fattijenishbek/extra_files/blob/master/Hnet-image.gif)

[Open](https://schedulecs.herokuapp.com/) the site on Heroku

## API Description:

* To view schedule: **/**
* To view all data from database: **/all**
* To view only professors from database: **/professors**
* To view only subjects from database: **/subjects**
* To view only groups from database: **/groups**
* To view one data with more information: for professors -> **/subjects/{id}** for subjects -> **subjects/{id}** for groups -> **groups{id}**
* To add new data using **POST** request: for professors -> **/professors-add** for subjects -> **subjects-add** for groups -> **groups-add**
* To **edit** one separated data by using POST request: 
      for professors -> **/professors/{id}/edit** for subjects -> **subjects/{id}/edit** for groups -> **groups/{id}edit**
* To **delete** one separated data by using POST request:
      for professors -> **/professors/{id}/edit** for subjects -> **subjects/{id}/edit** for groups -> **groups/{id}edit**

Now, you can just add and see data, but soon it will be available to autogenerate the schedule for universities:)
