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

import com.opensymphony.xwork2.Action;
import it.milidoni.wespeak_online.entity.User;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class AngularAction implements Action {

    private User personData = new User();

    @Override
    public String execute() {
        personData.setName("Mohaideen");
        personData.setRank(105);
        return SUCCESS;
    }

    public User getPersonData() {
        return personData;
    }

    public void setPersonData(User personData) {
        this.personData = personData;
    }

}
