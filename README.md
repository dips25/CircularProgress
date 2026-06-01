### Welcome to the CircularProgress wiki!

## Add it in your root settings.gradle at the end of repositories:

<code> ```dependencyResolutionManagement 
{ 
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) 
repositories {
 mavenCentral() 
 maven { url 'https://jitpack.io' } 
} 
} ```</code>

### Add the dependency

`dependencies {`
	        `implementation 'com.github.dips25:CircularProgress:v1.0-beta'`
	     `}`

### Use in XML

`<com.anim.circleanim.MyAnim`
        * `android:layout_width="80dp"`
*         `android:layout_height="80dp"`
*         `android:layout_centerInParent="true"`
*         `custom:startColor="@android:color/holo_orange_dark"`
*         `custom:secondColor="@android:color/holo_blue_dark"`
*         `custom:thirdColor="@android:color/holo_blue_dark"`
*         `custom:fourthColor="@android:color/holo_orange_dark"`
*         `custom:full="false"`
*         `custom:rotate="false"`
*         `custom:duration="700"`
*         `custom:clrbackground="@android:color/darker_gray"`
*         `android:id="@+id/my_anim"/>`


### Start in activity/fragment/dialog

 `var b = findViewById<MyAnim>(R.id.my_anim)`

 `var button = findViewById<Button>(R.id.start_anim)`

        `button.setOnClickListener {`

            `b.startAnim()`
        `}`
![Screen_recording_20250423_052810](https://github.com/user-attachments/assets/c9fbd2e6-e0ee-4d08-aba1-279b63c66f8e)
![Screen_recording_20250423_052956](https://github.com/user-attachments/assets/7ef552ed-2671-450c-b70c-3fe0fcfd2f23)
![Screen_recording_20250423_053615](https://github.com/user-attachments/assets/5309d802-c8c0-4a0f-b12a-9d62ee3e1db5)
![Screen_recording_20250423_053736](https://github.com/user-attachments/assets/e191a04f-ddd2-447c-8b93-26acdcf32e93)
