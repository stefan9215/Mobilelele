package mobilelele.mobilelele.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String name;
    private boolean isLoggedIn;

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }

    public void clear() {
        isLoggedIn = false;
        name = null;
    }
}
