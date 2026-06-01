## Add it in your root settings.gradle at the end of repositories:

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

```

## Add dependency
`implementation("com.github.dips25:CircularProgress:v1.1")`

## Add indicator to layout

```
<com.anim.circleanim.MyAnim
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        custom:startColor="@android:color/holo_red_dark"
        custom:secondColor="@android:color/holo_blue_dark"
        custom:thirdColor="@android:color/holo_green_dark"
        custom:fourthColor="@android:color/holo_orange_dark"
        custom:full="true"
        custom:rotate="true"
        custom:duration="700"
        custom:clrbackground="@android:color/darker_gray"
        android:id="@+id/my_anim"/>
```

<img width="368" height="832" alt="Screen_recording_20260601_150343-ezgif com-video-to-gif-converter" src="https://github.com/user-attachments/assets/115525c6-52c8-4d55-ba3b-6ed1ef3c74c2" />

<img width="720" height="1650" alt="Screenshot_20260601_150419" src="https://github.com/user-attachments/assets/3c650733-d6d2-4cd1-b7b9-4efcabe2733b" />
