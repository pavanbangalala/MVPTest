package holyape.com.mvp;

import android.text.TextUtils;

/**
 * Created by Pavan Bangalala on 06/01/17.
 */

public class LoginModel implements ILoginModel {

    private ILoginPresenter loingPresenter;
    private String strName,strPassword;
    public LoginModel(){
    }
    @Override
    public boolean validateCredentials(String name, String password) {

            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
                return false;
            }
            strName = name;
            strPassword = password;
            return true;

    }


}
