/*
 * Copyright 2017 Michele Milidoni <michelemilidoni@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.milidoni.wespeak_online.action;

import it.milidoni.wespeak_online.entity.User;
import it.milidoni.wespeak_online.service.UserService;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class LoginAction extends BaseJsonAction {

    private String email;
    private String password;

    @Override
    public void exec() throws Exception {
        UserService us = new UserService();
        try {
            User u = us.getUser(email, password);
            if (u != null) {
                ok = true;
                setLoggedUser(u);
            } else {
                ok = false;
                error = "Email and password not found";
            }
        } catch (ServiceException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
            error = ex.getMessage();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public boolean getOk() {
        return ok;
    }

}
