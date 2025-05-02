package com.example.Ca221Projects;
  @RestController
public class ResponseDemoController {
    @GetMapping("/success")
    public ResponseEntity<String> successResponse() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "SuccessHeader");
        return new ResponseEntity("Request successful!", headers, HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFoundResponse() {
        String errorMsg = "The resource you are looking for was not found.";
        return new ResponseEntity(errorMsg, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createResource() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/new-resource/123");
        return new ResponseEntity("Resource created successfully.", headers, HttpStatus.CREATED);
    }
}


