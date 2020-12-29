/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.controller;

import gm.ltt.tcv.web.model.AccountInfo;
import gm.ltt.tcv.web.service.CommonService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author X58
 */
@Controller
public class WebController {
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private CommonService commonService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHome(Model model) {
        String msisdn = request.getHeader("msisdn");
        if (msisdn == null || msisdn.isEmpty()) {
            msisdn = request.getHeader("MSISDN");
        }
        if (msisdn == null || msisdn.isEmpty()) {
            msisdn = request.getHeader("Msisdn");
        }
        AccountInfo info = commonService.getAccountInfo(msisdn);
        model.addAttribute("welcomeText", info.getWelcomeText());
        model.addAttribute("regText", info.getRegTextNgay());
        model.addAttribute("url", info.getRegUrlNgay());
        model.addAttribute("urlText", info.getUrlTextNgay());
        return "index";
    }
    
    @RequestMapping(value = "/tin-tuc", method = RequestMethod.GET)
    public String viewNews(Model model) {
        return "news";
    }
    
    @RequestMapping(value = "/kinh-doanh", method = RequestMethod.GET)
    public String viewBusiness(Model model) {
        return "business";
    }
    
    @RequestMapping(value = "/giao-duc", method = RequestMethod.GET)
    public String viewEducation(Model model) {
        return "education";
    }
    
    @RequestMapping(value = "/doi-song", method = RequestMethod.GET)
    public String viewSocial(Model model) {
        return "social";
    }
    
    @RequestMapping(value = "/danh-sach-trung-thuong", method = RequestMethod.GET)
    public String viewWinnerList(Model model) {
        String content = commonService.getWebContentByKey("danh-sach-trung-thuong");
        model.addAttribute("content", content);
        return "winner-list";
    }
    
    @RequestMapping(value = "/chinh-sach-dich-vu", method = RequestMethod.GET)
    public String viewPolicy(Model model) {
        String content = commonService.getWebContentByKey("chinh-sach-dich-vu");
        model.addAttribute("content", content);
        return "policy";
    }
    
    @RequestMapping(value = "/chinh-sach-bao-ve-thong-tin-ca-nhan", method = RequestMethod.GET)
    public String viewPrivacyPolicy(Model model) {
        String content = commonService.getWebContentByKey("chinh-sach-bao-ve-thong-tin-ca-nhan");
        model.addAttribute("content", content);
        return "privacy-policy";
    }
    
    @RequestMapping(value = "/the-le-dich-vu", method = RequestMethod.GET)
    public String viewRule(Model model) {
        String content = commonService.getWebContentByKey("the-le-dich-vu");
        model.addAttribute("content", content);
        return "rule";
    }
    
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String viewAccountInfo(Model model) {
        String msisdn = request.getHeader("msisdn");
        if (msisdn == null || msisdn.isEmpty()) {
            msisdn = request.getHeader("MSISDN");
        }
        if (msisdn == null || msisdn.isEmpty()) {
            msisdn = request.getHeader("Msisdn");
        }
        AccountInfo info = commonService.getAccountInfo(msisdn);
        model.addAttribute("welcomeText", info.getWelcomeText());
        model.addAttribute("regText", info.getRegTextNgay());
        model.addAttribute("url", info.getRegUrlNgay());
        model.addAttribute("urlText", info.getUrlTextNgay());
        return "account-info";
    }
    
}
