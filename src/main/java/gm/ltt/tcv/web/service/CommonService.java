/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.service;

import gm.ltt.tcv.web.entity.VUserSubscribeActive;
import gm.ltt.tcv.web.model.AccountInfo;
import gm.ltt.tcv.web.repository.impl.TcvWebContentRepositoryImpl;
import gm.ltt.tcv.web.repository.impl.VUserSubscribeActiveRepositoryImpl;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author X58
 */
@Service
public class CommonService {
    
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    
    @Autowired
    private TcvWebContentRepositoryImpl tcvWebContentRepositoryImpl;
    
    @Autowired
    private VUserSubscribeActiveRepositoryImpl vUserSubscribeActiveRepositoryImpl;
    
    public String getWebContentByKey(String key) {
        return tcvWebContentRepositoryImpl.findByKey(key).getValue();
    }
    
    public AccountInfo getAccountInfo(String msisdn) {
        AccountInfo info = new AccountInfo();
        if (msisdn == null || msisdn.isEmpty()) {
            info.setWelcomeText("Không nhận diện được số điện thoại. Để đăng ký dịch vụ trên website http://glive.vn, vui lòng bật 3G hoặc soạn tin nhắn như hướng dẫn dưới đây:");
            info.setRegTextNgay("Soạn DK gửi 9506 (3000đ/ngày, gia hạn hàng ngày) hoặc click ");
            info.setRegUrlNgay(getRegUrl(msisdn));
            info.setUrlTextNgay("ĐĂNG KÝ");
        } else {
            VUserSubscribeActive active = vUserSubscribeActiveRepositoryImpl.findByMsisdn(Double.valueOf(msisdn));
            if (active != null) {
                info.setWelcomeText("Xin chào " + msisdn);
                info.setRegTextNgay("Bạn đang sử dụng dịch vụ Thẻ cào vàng (3000đ/ngày, gia hạn hàng ngày), để hủy dịch vụ soạn HUY TCV gửi 9506 hoặc click ");
                info.setRegUrlNgay(getUnregUrl(msisdn));
                info.setUrlTextNgay("HỦY DỊCH VỤ");
            } else {
                info.setWelcomeText("Xin chào " + msisdn);
                info.setRegTextNgay("Bạn chưa đăng ký dịch vụ Thẻ cào vàng. Để đăng ký soạn DK gửi 9506 (3000đ/ngày, gia hạn hàng ngày) hoặc click ");
                info.setRegUrlNgay(getRegUrl(msisdn));
                info.setUrlTextNgay("ĐĂNG KÝ");
            }
        }
        return info;
    }
    
    public String getRegUrl(String msisdn) {
        String requestid = String.valueOf(System.currentTimeMillis());
        String returnurl = "http://glive.vn";
        String backurl = returnurl;
        String cp = "1000447";
        String service = "1000563";
        String packageName = "1001143";
        String requestdatetime = DATE_FORMAT.format(new Date());
        String channel = "WAP";
        if (msisdn == null || msisdn.isEmpty()) {
            channel = "WEB";
        }
        String securepass = "TherCafoVafng123";
        String securecode = DigestUtils.md5Hex(requestid + returnurl + backurl + cp + service + packageName + requestdatetime + channel + securepass);
        String link = "http://bss.vascloud.com.vn/unify/register.jsp?requestid=" + requestid + "&returnurl=" + URLEncoder.encode(returnurl) + "&backurl=" + URLEncoder.encode(backurl) + "&cp=" + cp + "&service=" + service + "&package=" + packageName + "&requestdatetime=" + requestdatetime + "&channel=" + channel + "&securecode=" + securecode;
        return link;
    }
    
    public String getUnregUrl(String msisdn) {
        String requestid = String.valueOf(System.currentTimeMillis());
        String returnurl = "http://glive.vn";
        String backurl = returnurl;
        String cp = "1000447";
        String service = "1000563";
        String packageName = "1001143";
        String requestdatetime = DATE_FORMAT.format(new Date());
        String channel = "WAP";
        if (msisdn == null || msisdn.isEmpty()) {
            channel = "WEB";
        }
        String securepass = "TherCafoVafng123";
        String securecode = DigestUtils.md5Hex(requestid + returnurl + backurl + cp + service + packageName + requestdatetime + channel + securepass);
        String link = "http://bss.vascloud.com.vn/unify/cancel.jsp?requestid=" + requestid + "&returnurl=" + URLEncoder.encode(returnurl) + "&backurl=" + URLEncoder.encode(backurl) + "&cp=" + cp + "&service=" + service + "&package=" + packageName + "&requestdatetime=" + requestdatetime + "&channel=" + channel + "&securecode=" + securecode;
        return link;
    }
    
}
