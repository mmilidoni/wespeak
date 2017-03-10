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
package it.milidoni.wespeak_online.action.call;

import it.milidoni.wespeak_online.action.*;
import it.milidoni.wespeak_online.entity.PhoneCall;
import it.milidoni.wespeak_online.entity.User;
import it.milidoni.wespeak_online.service.PhoneCallService;
import it.milidoni.wespeak_online.util.PhoneCallResultBean;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class NextCallAction extends BaseJsonAction {

    private ArrayList<PhoneCallResultBean> calls = new ArrayList<>();

    @Override
    public void exec() {
        PhoneCallService us = new PhoneCallService();

        try {
            for (PhoneCall pc : us.listNext(getLoggedUser().getId())) {
                String receiverName = "";
                String receiverSkypeId = "";
                String receiverPic = "";
                String classe;
                if (pc.getInterlocutor() != null) {
                    User receiver;
                    if (pc.getOwner().getId().equals(getLoggedUser().getId())) {
                        receiver = pc.getInterlocutor();
                    } else {
                        receiver = pc.getOwner();
                    }
                    receiverName = receiver.getName();
                    receiverSkypeId = receiver.getSkypeId();
                    if (receiver.getPicture() != null && !receiver.getPicture().isEmpty()) {
                        receiverPic = receiver.getPicture();
                    }
                    classe = "event-success";
                } else {
                    classe = "event-info";
                }

                calls.add(new PhoneCallResultBean(pc.getId().toString(),
                        pc.getTopic().getName(), "#",
                        String.valueOf(pc.getDateTime().getTime()),
                        String.valueOf(pc.getDateTime().getTime() + 1800000),
                        classe, receiverName, receiverSkypeId, receiverPic));
            }
            ok = true;
        } catch (ServiceException ex) {
            Logger.getLogger(LastCallAction.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
            error = ex.getMessage();
        }
    }

    public ArrayList<PhoneCallResultBean> getCalls() {
        return calls;
    }

    public void setCalls(ArrayList<PhoneCallResultBean> calls) {
        this.calls = calls;
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
