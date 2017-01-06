package holyape.com.mvp;

/**
 * Created by Pavan Bangalala on 06/01/17.
 */

public interface IAsyncLoginModel {
    public void validateCredentials(ILoginFinishListener listener, String name, String password);
}
