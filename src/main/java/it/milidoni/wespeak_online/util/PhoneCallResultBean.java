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
package it.milidoni.wespeak_online.util;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class PhoneCallResultBean {

    private String id, title, url,
            start, end, classe, receiverName, receiverSkype, receiverPic;

    public PhoneCallResultBean(String id, String title, String url, 
            String start, String end, String classe, 
            String receiverName, String receiverSkype, String receiverPic) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.start = start;
        this.end = end;
        this.classe = classe;
        this.receiverName = receiverName;
        this.receiverSkype = receiverSkype;
        this.receiverPic = receiverPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverSkype() {
        return receiverSkype;
    }

    public void setReceiverSkype(String receiverSkype) {
        this.receiverSkype = receiverSkype;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getReceiverPic() {
        return receiverPic;
    }

    public void setReceiverPic(String receiverPic) {
        this.receiverPic = receiverPic;
    }

}
