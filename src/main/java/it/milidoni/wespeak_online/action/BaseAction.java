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

import com.opensymphony.xwork2.ActionSupport;
import it.milidoni.wespeak_online.entity.User;
import it.milidoni.wespeak_online.util.IntegerStringPair;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

    private static final String SESSION_LOGGED_USER = "loggedUser",
            INFO_MESSAGE = "infoMessage",
            WARN_MESSAGE = "warnMessage",
            ERR_MESSAGE = "errMessage";
    private Map<String, Object> session;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public String getIp() {
        if (request == null) {
            return null;
        }
        String s = request.getHeader("X-FORWARDED-FOR");
        if (s == null) {
            s = request.getRemoteAddr();
            System.out.println("X-FORWARDED-FOR era null");
        }
        System.out.println("Remote Ip Address: " + s);
        return s;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
        //System.out.println("Sessione corrente: "+map);
    }

    public User getLoggedUser() {
        return (User) session.get(SESSION_LOGGED_USER);
    }

    public void setLoggedUser(User user) {
        session.put(SESSION_LOGGED_USER, user);
    }

    public void setInfoMessage(String message) {
        session.put(INFO_MESSAGE, message);
    }

    public String getInfoMessage() {
        return (String) session.remove(INFO_MESSAGE);
    }

    public void setWarningMessage(String message) {
        session.put(WARN_MESSAGE, message);
    }

    public String getWarningMessage() {
        return (String) session.remove(WARN_MESSAGE);
    }

    public void setErrorMessage(String message) {
        session.put(ERR_MESSAGE, message);
    }

    public String getErrorMessage() {
        return (String) session.remove(ERR_MESSAGE);
    }

    public String getAvatarDefaultPath() {
        return request.getContextPath() + "/images/avatar_default/";
    }

    private static ArrayList<IntegerStringPair> l = null;

    public ArrayList<IntegerStringPair> getHoursFractions() {
        if (l == null) {
            System.out.println("Regenerating hours fractions");
            l = new ArrayList<>();
            l.add(new IntegerStringPair(0, "0.00"));
            l.add(new IntegerStringPair(1, "1.00"));
            l.add(new IntegerStringPair(2, "2.00"));
            l.add(new IntegerStringPair(3, "3.00"));
            l.add(new IntegerStringPair(4, "4.00"));
            l.add(new IntegerStringPair(5, "5.00"));
            l.add(new IntegerStringPair(6, "6.00"));
            l.add(new IntegerStringPair(7, "7.00"));
            l.add(new IntegerStringPair(8, "8.00"));
            l.add(new IntegerStringPair(9, "9.00"));
            l.add(new IntegerStringPair(1, "10.00"));
            l.add(new IntegerStringPair(11, "11.00"));
            l.add(new IntegerStringPair(12, "12.00"));
            l.add(new IntegerStringPair(13, "13.00"));
            l.add(new IntegerStringPair(14, "14.00"));
            l.add(new IntegerStringPair(15, "15.00"));
            l.add(new IntegerStringPair(16, "16.00"));
            l.add(new IntegerStringPair(17, "17.00"));
            l.add(new IntegerStringPair(18, "18.00"));
            l.add(new IntegerStringPair(19, "19.00"));
            l.add(new IntegerStringPair(20, "20.00"));
            l.add(new IntegerStringPair(21, "21.00"));
            l.add(new IntegerStringPair(22, "22.00"));
            l.add(new IntegerStringPair(23, "23.00"));
        }

        return l;
    }

    public ArrayList<Character> getSessi() {
        ArrayList<Character> res = new ArrayList<>();
        res.add('M');
        res.add('F');
        return res;
    }

    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public ArrayList<IntegerStringPair> getTimezones() throws Exception {
        throw new Exception("aaa");
    }

    public ArrayList<IntegerStringPair> getCountries() throws Exception {
        throw new Exception("aaa");
    }

    @Override
    public String execute() {
        try {
            return super.execute();
        } catch (Exception e) {
            Logger.getLogger(BaseAction.class.getName()).log(Level.SEVERE, e.getMessage());
            return "404";
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
