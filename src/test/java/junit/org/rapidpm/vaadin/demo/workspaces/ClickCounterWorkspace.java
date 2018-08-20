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
package junit.org.rapidpm.vaadin.demo.workspaces;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.rapidpm.dependencies.core.logger.HasLogger;

import static java.lang.String.valueOf;
import static org.rapidpm.vaadin.addons.framework.ComponentIDGenerator.buttonID;
import static org.rapidpm.vaadin.addons.framework.ComponentIDGenerator.spanID;

public class ClickCounterWorkspace extends Composite<Div> implements HasLogger {

  // read http://vaadin.com/testing for more infos
  public static final String BTN_CLICK_ME_ID   = buttonID().apply(ClickCounterWorkspace.class, "btn-click-me");
  public static final String LB_CLICK_COUNT_ID = spanID().apply(ClickCounterWorkspace.class, "lb-click-count");


  private final Span lbClickCount = new Span() {{
    setId(LB_CLICK_COUNT_ID);
    setText("0");
  }};

  private final Button btnClickMe = new Button() {{
    setId(BTN_CLICK_ME_ID);
    setText("click me");
    addClickListener(event -> lbClickCount.setText(valueOf(++clickcount)));
  }};

  private final VerticalLayout layout = new VerticalLayout(
      btnClickMe,
      lbClickCount
  ) {{
    setSizeFull();
  }};


  private int clickcount = 0;


  public ClickCounterWorkspace() {
    getContent().add(layout);
  }
}
