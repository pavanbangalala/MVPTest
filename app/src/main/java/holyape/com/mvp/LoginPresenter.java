package holyape.com.mvp;

/**
 * Created by Pavan Bangalala on 06/01/17.
 */

public class LoginPresenter implements ILoginPresenter,ILoginFinishListener {

    private IMainActivity mainActivity;
    private IAsyncLoginModel loginModel;

    public LoginPresenter(IMainActivity view){
        this.mainActivity = view;
        loginModel = new AsyncLoginModel();
    }

    @Override
    public void attempLogin(String name, String password) {
        loginModel.validateCredentials(this,name,password);
    }

    @Override
    public void loginFailed() {
        mainActivity.loginFailed();
    }

    @Override
    public void loginSuccess() {
        mainActivity.loginSuccess();
    }
}
