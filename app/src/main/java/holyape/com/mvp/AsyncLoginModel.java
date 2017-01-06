package holyape.com.mvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Pavan Bangalala on 06/01/17.
 */

public class AsyncLoginModel implements IAsyncLoginModel {

    private String strName,strPassword;

    @Override
    public void validateCredentials(final ILoginFinishListener listener, final String name, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
                    listener.loginFailed();
                }
                else {
                    strName = name;
                    strPassword = password;
                    listener.loginSuccess();
                }
            }
        },2000);


    }
}
