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
package qool;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import qool.dao.DbException;
import qool.dao.JPADbManager;
import qool.db.Course;

/**
 * FXML Controller class
 *
 * @author shame
 */
public class CourseController implements Initializable {

    final private CourseMapping mapping = new CourseMapping();
    @FXML
    private Button submit;
    @FXML
    private TextField title;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.textProperty().bindBidirectional(mapping.titleProperty());
    }

    @FXML
    protected void save(ActionEvent evt) {
        try {
            JPADbManager.getDbManager().save(mapping.course);
            mapping.title.set("");
        } catch (DbException ex) {
            System.out.println("Error Ahh!");
        }
    }

    private static class CourseMapping {
        private final StringProperty title = new SimpleStringProperty();
        private final Course course = new Course();

        public String getTitle() {
            return title.get();
        }

        public void setTitle(String value) {
            title.set(value);
            course.setTitle(value);
        }

        public StringProperty titleProperty() {
            return title;
        }

    }
}
