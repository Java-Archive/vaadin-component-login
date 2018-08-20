/**
 * Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package junit.org.rapidpm.vaadin.component.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import junit.org.rapidpm.vaadin.demo.MainView;
import org.rapidpm.vaadin.component.login.LoginView;


@Route("login")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MyLoginView extends LoginView {
  public static final String LOGGED_IN = "logged-in";

  @Override
  public void reactOnFailedLogin() {
    logger().warning("Login is not acctepd..");
    Notification.show("Credentials not accepted..");
  }

  @Override
  public void navigateToApp() {
    UI.getCurrent().navigate(MainView.class);
  }

  @Override
  public boolean checkCredentials() {
    String username = username();
    String password = password();

    // USE Apache Shiro for example : demo you can find here
    // https://github.com/Nano-Vaadin-Demos/nano-vaadin-meecrowave-shiro-V10

    // DON NOT USE THIS IN PRODUCTION !!
    boolean isOK = username != null && username.equals("admin") ||
                   password != null && password.equals("admin");

    UI.getCurrent().getSession().setAttribute(LOGGED_IN, isOK);
    // DON NOT USE THIS IN PRODUCTION !!

    return isOK;

  }
}
