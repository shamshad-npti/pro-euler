/*
 * Copyright (C) 2015 Shamshad Alam
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package qool.view.admin;

import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import qool.view.QoolWidget;

/**
 *
 * @author Shamshad Alam
 */
public class AdminLeftPane extends QoolWidget {

    private CourseWidget courseWidget;
    private QuizWidget quizWidget;
    public AdminLeftPane(AdminView view) {
        super(view);
    }

    @Override
    public Pane createWidget() {
        ListView<String> lv = new ListView<>();
        lv.getItems().addAll("Course", "User", "Question", "Question Type");
        lv.getSelectionModel().selectedItemProperty().addListener((e) -> {
            switch (lv.getSelectionModel().getSelectedIndex()) {
                case 0:
                    courseWidget = new CourseWidget(getView());
                    getView().getViewManager().setMainPane(courseWidget);
                    break;
                case 1:
                    quizWidget = new QuizWidget(getView());
                    getView().getViewManager().setMainPane(quizWidget);
                    break;
            }
        });
        VBox box = new VBox();
        box.getChildren().add(lv);
        return box;
    }

}
