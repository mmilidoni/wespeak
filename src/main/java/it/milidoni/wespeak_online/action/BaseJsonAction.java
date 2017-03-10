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

import static com.opensymphony.xwork2.Action.SUCCESS;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public abstract class BaseJsonAction extends BaseAction {

    protected String error;
    protected boolean ok;

    public abstract void exec() throws Exception;

    public abstract String getError();

    public abstract boolean getOk();

    @Override
    public String execute() {
        try {
            exec();
            ok = true;
        } catch (ServiceException e) {
            ok = false;
            error = e.getUserMessage();
            Logger.getLogger(BaseJsonAction.class.getName()).log(Level.SEVERE, e.getDetailedMessage());
        } catch (Exception e) {
            ok = false;
            error = "Internal error";
            Logger.getLogger(BaseJsonAction.class.getName()).log(Level.SEVERE, e.getMessage());
            e.printStackTrace();
        }
        return SUCCESS;
    }

}
