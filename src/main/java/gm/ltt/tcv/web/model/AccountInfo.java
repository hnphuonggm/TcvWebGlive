/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.model;

/**
 *
 * @author X58
 */
public class AccountInfo {

    private String welcomeText;
    private String regTextNgay;
    private String regUrlNgay;
    private String urlTextNgay;

    public AccountInfo() {
    }

    public AccountInfo(String welcomeText, String regTextNgay, String regUrlNgay, String urlTextNgay) {
        this.welcomeText = welcomeText;
        this.regTextNgay = regTextNgay;
        this.regUrlNgay = regUrlNgay;
        this.urlTextNgay = urlTextNgay;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    public String getRegTextNgay() {
        return regTextNgay;
    }

    public void setRegTextNgay(String regTextNgay) {
        this.regTextNgay = regTextNgay;
    }

    public String getRegUrlNgay() {
        return regUrlNgay;
    }

    public void setRegUrlNgay(String regUrlNgay) {
        this.regUrlNgay = regUrlNgay;
    }

    public String getUrlTextNgay() {
        return urlTextNgay;
    }

    public void setUrlTextNgay(String urlTextNgay) {
        this.urlTextNgay = urlTextNgay;
    }

}
