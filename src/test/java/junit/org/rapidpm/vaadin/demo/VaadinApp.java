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
package junit.org.rapidpm.vaadin.demo;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import junit.org.rapidpm.vaadin.component.login.MyLoginView;
import org.rapidpm.dependencies.core.logger.HasLogger;

import static junit.org.rapidpm.vaadin.component.login.MyLoginView.LOGGED_IN;

@Route("")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class VaadinApp extends VerticalLayout implements HasLogger {

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);

    // USE Apache Shiro for example : demo you can find here
    // https://github.com/Nano-Vaadin-Demos/nano-vaadin-meecrowave-shiro-V10

    // DON NOT USE THIS IN PRODUCTION !!
    UI            current        = UI.getCurrent();
    VaadinSession currentSession = current.getSession();
    Object        attribute      = currentSession.getAttribute(LOGGED_IN);
    Boolean       isLoggedIn     = (attribute != null) ? (Boolean)attribute : Boolean.FALSE;
    // DON NOT USE THIS IN PRODUCTION !!


    // NOW SWITCH VIEW BASED ON DECISIONS
    if (isLoggedIn) {
      current.navigate(MainView.class);
    } else {
      current.navigate(MyLoginView.class);
    }
  }
}
