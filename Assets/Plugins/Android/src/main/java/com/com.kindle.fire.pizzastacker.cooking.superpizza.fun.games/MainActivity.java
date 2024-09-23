
package com.kindle.fire.pizzastacker.cooking.superpizza.fun.games;

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
        SingularConfig config = new SingularConfig("funbashtechnologies_322c46c1", "a1a512f0e169c4dc8a688b0708b8cf2a")
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
