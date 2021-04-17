# CodelabsforAndroidDeveloperFundamentalsHomework

* On your computer's file system (not in Android Studio), make a copy of the ExistingProject directory.
*Rename the copied directory to HelloProject.

Here's how to change the file and the package references in your app to the new name:

Start Android Studio.
Select Open an existing the hello toast app project. If you already have the project open in Android Studio, select File > Open.
Navigate to the NewProject directory, select it, and click OK.
Select Build > Clean Project to remove the auto-generated files.
Click the 1:Project side-tab and choose Android from the drop-down menu to see your files in the Project: Android view.
Expand the app > java folder.
Right-click com.example.android.existingproject and select Refactor > Rename. A Warning dialog is displayed. Select Rename package.
The Rename dialog is displayed. Give a new name to your project.
Select Search in comments and strings and Search for text occurrences. Click Refactor.
The Find: Refactoring Preview pane appears, showing the code to be refactored. Click Do Refactor.
Expand the res > values folder and double-click the strings.xml file.
Change the app_name string value to "Hello Constraint".