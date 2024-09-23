------- SDK Installation to Unity------------------
----------------------------------------------------
Follow steps of SDK installation from the Website https://support.singular.net/hc/en-us/articles/360037635452-Unity-Package-Manager-SDK-Integration-Guide?navigation_side_bar=true

The 2 Most Important Points which is required is 
 1. Intsall package of Singular SDK using git Link-> https://github.com/singular-labs/Singular-Unity-SDK.git
 2. Download this and Extract it to Plugins Folder-> https://s3.us-west-2.amazonaws.com/maven.singular.net/unity/UPM-non-EDM4U/5.2.1/Plugins.zip

Then Drag and Drop "SingularSDKObject" to your scene which will have Component Name Singular SDK (.cs) input Your API key and API Secret.

--------Gradle Files---------------------------------
----------------------------------------------------
After both steps In Plugins>Plugins>Android there are 2 files build.gradle and settings.gradle 
if your project contain it already copy paste the code from these files otherwise copy paste the files Directly..


-------AndroidManifist.xml---------------------------
----------------------------------------------------
Then create the Android Manifist File from Publishing Settings if its not already created.. then at start change the package name as per your project 
Then Add these lines before <application>
	<uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="BIND_GET_INSTALL_REFERRER_SERVICE" />
	<uses-permission android:name="com.android.vending.CHECK_LICENSE" />
	<uses-permission android:name="com.google.android.gms.permission.AD_ID" />

Also add these after <\intent-filter>
			<intent-filter android:autoVerify="true">
				<action android:name="android.intent.action.VIEW" />
				<category android:name="android.intent.category.DEFAULT" />
				<category android:name="android.intent.category.BROWSABLE" />
				<data android:scheme="http" />
				<data android:scheme="https" />
				<data android:host="funbashtechnologies.sng.link" />
				<data android:pathPrefix="/A" />
			</intent-filter>

---------MainActivity.java---------------------------
----------------------------------------------------

to create this file you need to create all these folders in Assets\Plugins\Android\ Folder exactly where the AndroidManifest is located ...

Create folders like that src\main\java\com\com.yourpackagenameHere\MainActivity.java.. In that file write this below code 

package com.yourPacakgeNameHere;

import com.unity3d.player.UnityPlayerActivity;
import android.os.Bundle;
import com.singular.sdk.Singular;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularLinkHandler;
import com.singular.sdk.SingularLinkParams;

public class MainActivity extends UnityPlayerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SingularConfig singularConfig = getSingularConfig();
        Singular.init(this, singularConfig);
    }

    SingularConfig getSingularConfig() {
        SingularConfig config = new SingularConfig("Singular_API_Key", "Singular_API_Secret")
            .withSingularLink(getIntent(), new SingularLinkHandler() {
                @Override
                public void onResolved(SingularLinkParams params) {
                    String deeplink = params.getDeeplink();
                    String passthrough = params.getPassthrough();
                    boolean isDeferred = params.isDeferred();

                    // Handle the deep link here
                }
            })
            .withCustomUserId("custom_user_id");

        return config;
    }
}
