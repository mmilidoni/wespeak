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

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class HomeAction extends BaseAction {

    @Override
    public String execute() {
        if (getLoggedUser() == null) {
            return LOGIN;
        } else if (getLoggedUser().getId() > 0) {
            return "userHome";
        } else {
            return ERROR;
        }
    }

}
