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
import it.milidoni.wespeak_online.util.PhoneCallEventsBean;
import it.milidoni.wespeak_online.util.PhoneCallResultBean;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class CallListAction extends BaseJsonAction {

    private Long from, to;
    private PhoneCallEventsBean events;

    @Override
    public void exec() {
        PhoneCallService us = new PhoneCallService();

        if (from == null) {
            from = 1488929453637l;
        }
        if (to == null) {
            to = 1488929463637l;
        }
        Date fromDate = new Date(from);
        Date toDate = new Date(to);

        events = new PhoneCallEventsBean();

        try {
            events.setSuccess("1");

            for (PhoneCall pc : us.list(getLoggedUser().getId(), fromDate, toDate)) {
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
                    receiverSkypeId = "<a href='skype:"
                            + receiver.getSkypeId() + "'>S</a>";
                    receiverPic = receiver.getPicture();
                    classe = "event-success";
                } else {
                    classe = "event-info";
                }

                events.getResult().add(new PhoneCallResultBean(pc.getId().toString(),
                        pc.getTopic().getName(), "#",
                        String.valueOf(pc.getDateTime().getTime()),
                        String.valueOf(pc.getDateTime().getTime() + 1800000),
                        classe, receiverName, receiverSkypeId, receiverPic));
            }
            ok = true;
        } catch (ServiceException ex) {
            Logger.getLogger(CallListAction.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
            error = ex.getMessage();
        }
    }

    public PhoneCallEventsBean getEvents() {
        return events;
    }

    public void setEvents(PhoneCallEventsBean events) {
        this.events = events;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
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
