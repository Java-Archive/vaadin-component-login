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


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import junit.org.rapidpm.vaadin.demo.workspaces.ClickCounterWorkspace;
import org.rapidpm.dependencies.core.logger.HasLogger;

@Route("main")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainView extends Composite<Div> implements HasLogger {

  public MainView() {
    logger().info("setting now the main ui content..");
    getContent().add(new ClickCounterWorkspace());
  }


}
