package november10.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/dummy", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
public class DummyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DummyController.class);
   
	
	 
    @GetMapping("/{dummyId}")
    public ResponseEntity<String> getDummyById(@PathVariable("dummyId") String dummyId) {
          return ResponseEntity.ok("Dummy with ID :" + dummyId);
    }

   
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<String> getDummy(@RequestParam(value="param1",required = false) String param1,@RequestParam(value="param2",required = false) String param2) {
          return ResponseEntity.ok(param1+" "+param2);
    }

    
   
}
