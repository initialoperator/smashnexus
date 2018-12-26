package com.zentech.smashnexus.controller;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;

        import javax.xml.ws.Response;

@RestController
public class ConfigController {

    @RequestMapping(method = RequestMethod.GET, value = "/config")
    @ResponseBody
    public String getConfig(){
        return "Value is available";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/thesecond")
    @ResponseBody
    public String getConfig2(){
        return "Value22222 is available";
    }
}
