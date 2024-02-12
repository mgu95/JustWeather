package mgu95.contollers;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/image")
public class ImageController {

    @GetMapping(value = "/getIcon")
    public @ResponseBody byte[] getImage(@RequestParam String dayCycle, @RequestParam int code) throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/images/" + dayCycle + "/" + code + ".png");
        if (in == null) {
            return null;
        }
        return IOUtils.toByteArray(in);
    }
}
