Certainly! Here are the top 50 Spring REST API interview questions with answers and examples:

1. Q: What is Spring REST API?
    
    A: Spring REST API is a part of the Spring Framework that provides support for building RESTful web services in Java.

2. Q: How can you create a RESTful API using Spring Boot?
    
    A: You can create a RESTful API using Spring Boot by creating a Spring Boot project and defining REST endpoints using Spring's `@RestController` annotation.

Example:
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
```

3. Q: How can you handle HTTP GET requests in Spring REST?
    
    A: You can handle HTTP GET requests in Spring REST by using the `@GetMapping` annotation.

Example:
```java
@GetMapping("/users/{id}")
public User getUserById(@PathVariable Long id) {
    // Code to retrieve user by ID
}
```

4. Q: How can you handle HTTP POST requests in Spring REST?
    
    A: You can handle HTTP POST requests in Spring REST by using the `@PostMapping` annotation.

Example:
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // Code to create a new user
}
```

5. Q: How can you handle HTTP PUT requests in Spring REST?
    
    A: You can handle HTTP PUT requests in Spring REST by using the `@PutMapping` annotation.

Example:
```java
@PutMapping("/users/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    // Code to update the user with the given ID
}
```

6. Q: How can you handle HTTP DELETE requests in Spring REST?
    
    A: You can handle HTTP DELETE requests in Spring REST by using the `@DeleteMapping` annotation.

Example:
```java
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable Long id) {
    // Code to delete the user with the given ID
}
```

7. Q: How can you pass parameters in the URL in Spring REST?
    
    A: You can pass parameters in the URL in Spring REST using `@PathVariable` for path parameters and `@RequestParam` for query parameters.

Example with path parameter:
```java
@GetMapping("/users/{id}")
public User getUserById(@PathVariable Long id) {
    // Code to retrieve user by ID
}
```

Example with query parameter:
```java
@GetMapping("/users")
public List<User> getUsersByRole(@RequestParam String role) {
    // Code to retrieve users by role
}
```

8. Q: What is the purpose of the `@RequestBody` annotation in Spring REST?
    
    A: The `@RequestBody` annotation is used to map the request body of an HTTP request to a method parameter in Spring REST.

Example:
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // Code to create a new user
}
```

9. Q: What is the purpose of the `@ResponseBody` annotation in Spring REST?
    
    A: The `@ResponseBody` annotation is used to indicate that the return value of a method should be written directly to the HTTP response body.

Example:
```java
@GetMapping("/hello")
@ResponseBody
public String sayHello() {
    return "Hello, world!";
}
```

10. Q: What is the difference between `@PathVariable` and `@RequestParam` in Spring REST?
    
    A: 
- `@PathVariable`: It is used to extract values from the URI path.
- `@RequestParam`: It is used to extract values from query parameters in the URL.

11. Q: How can you handle exceptions in Spring REST APIs?
    
    A: You can handle exceptions in Spring REST APIs using the `@ExceptionHandler` annotation to define custom exception handling methods.

Example:
```java
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}
```

12. Q: What is the purpose of the `ResponseEntity` class in Spring REST?
    
    A: The `ResponseEntity` class represents an HTTP response, including status code, headers, and the response body.

Example:
```java
@GetMapping("/hello")
public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello, world!");
}
```

13. Q: How can you return different HTTP status codes in Spring REST?
    
    A: You can return different HTTP status codes in Spring REST by using the `ResponseEntity` class or by using the appropriate annotations such as `@ResponseStatus`.

Example with `ResponseEntity`:
```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    if (user != null) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.notFound().build();
    }
}
```

Example with `@ResponseStatus`:
```java
@DeleteMapping("/users/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
}
```

14. Q: How can you handle CORS (Cross-Origin Resource Sharing) in Spring REST?
    
    A: You can handle CORS in Spring REST by configuring CORS settings in your Spring Boot application.

Example:
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://example.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
```

15. Q: What is the purpose of the `@CrossOrigin` annotation in Spring REST?
    
    A: The `@CrossOrigin` annotation is used to enable CORS for specific controller methods.

Example:
```java
@RestController
public class HelloController {
    @CrossOrigin(origins = "http://example.com")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
```

16. Q: What is the `MediaType` class in Spring REST used for?
    
    A: The `MediaType` class in Spring REST is used to represent Internet Media Types (MIME types) for HTTP requests and responses.

Example:
```java
@GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public Data getData() {
    // Code to retrieve data
}
```

17. Q: What is content negotiation in Spring REST?
    
    A: Content negotiation in Spring REST is the process of determining the best response representation based on the client's request.

Example:
```java
@GetMapping(value = "/data", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public Data getData() {
    // Code to retrieve data
}
```

18. Q: What is the purpose of the `consumes` attribute in Spring REST annotations?
    
    A: The `consumes` attribute is used to specify the media types that a method can consume (accept) as request content.

Example:
```java
@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
public User createUser(@RequestBody User user) {
    // Code to create a new user
}
```

19. Q: What is the purpose of the `produces` attribute in Spring REST annotations?
    
    A: The `produces` attribute is used to specify the media types that a method can

 produce as response content.

Example:
```java
@GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public Data getData() {
    // Code to retrieve data
}
```

20. Q: How can you handle validation in Spring REST APIs?
    
    A: You can handle validation in Spring REST APIs using annotations such as `@Valid` and `@Validated` along with validation constraints.

Example with `@Valid`:
```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    // Code to create a new user
}
```

Example with `@Validated`:
```java
@Validated
public interface MyService {
    void process(@NotBlank String data);
}
```

21. Q: What is the purpose of the `@Valid` annotation in Spring REST?
    
    A: The `@Valid` annotation is used to indicate that the method parameter should be validated.

Example:
```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    // Code to create a new user
}
```

22. Q: What is the purpose of the `@Validated` annotation in Spring REST?
    
    A: The `@Validated` annotation is used at the class level to enable method-level validation.

Example:
```java
@Validated
public interface MyService {
    void process(@NotBlank String data);
}
```

23. Q: How can you handle file uploads in Spring REST APIs?
    
    A: You can handle file uploads in Spring REST APIs by using the `@RequestParam` annotation with `MultipartFile`.

Example:
```java
@PostMapping("/upload")
public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    // Code to handle file upload
}
```

24. Q: How can you handle file downloads in Spring REST APIs?
    
    A: You can handle file downloads in Spring REST APIs by using the `ResponseEntity` class to set the appropriate response headers.

Example:
```java
@GetMapping("/download")
public ResponseEntity<Resource> downloadFile() throws IOException {
    // Code to read the file and create Resource object
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=myfile.txt");
    return ResponseEntity.ok()
            .headers(headers)
            .body(resource);
}
```

25. Q: How can you implement pagination in Spring REST APIs?
    
    A: You can implement pagination in Spring REST APIs using query parameters to specify the page number and size.

Example:
```java
@GetMapping("/users")
public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userRepository.findAll(pageable);
}
```

26. Q: What is HATEOAS in Spring REST?
    
    A: HATEOAS stands for "Hypermedia as the Engine of Application State," and it allows clients to navigate a REST API dynamically by following hypermedia links.

Example using `ResourceSupport`:
```java
@RestController
public class UserController {
    @GetMapping("/users/{id}")
    public Resource<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        Resource<User> resource = new Resource<>(user);
        resource.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
        return resource;
    }
}
```

27. Q: What is the `linkTo` method in Spring REST?
    
    A: The `linkTo` method is used to create hypermedia links to controller methods.

Example:
```java
Resource<User> resource = new Resource<>(user);
resource.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
```

28. Q: What is the purpose of the `@RestControllerAdvice` annotation in Spring REST?
    
    A: The `@RestControllerAdvice` annotation is used to define global exception handling for REST controllers.

Example:
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

29. Q: What is the purpose of the `@RequestMapping` annotation in Spring REST?
    
    A: The `@RequestMapping` annotation is used to map HTTP requests to specific handler methods.

Example:
```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> getUsers() {
    // Code to retrieve users
}
```

30. Q: What is the difference between `@RequestMapping` and `@GetMapping` in Spring REST?
    
    A: 
- `@RequestMapping`: It is a general-purpose annotation that maps all HTTP methods by default.
- `@GetMapping`: It is a specialized form of `@RequestMapping` that maps HTTP GET requests.

31. Q: What is the purpose of the `@PostMapping` annotation in Spring REST?
    
    A: The `@PostMapping` annotation is used to map HTTP POST requests to specific handler methods.

Example:
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // Code to create a new user
}
```

32. Q: What is the purpose of the `@PutMapping` annotation in Spring REST?
    
    A: The `@PutMapping` annotation is used to map HTTP PUT requests to specific handler methods.

Example:
```java
@PutMapping("/users/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    // Code to update the user with the given ID
}
```

33. Q: What is the purpose of the `@DeleteMapping` annotation in Spring REST?
    
    A: The `@DeleteMapping` annotation is used to map HTTP DELETE requests to specific handler methods.

Example:
```java
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable Long id) {
    // Code to delete the user with the given ID
}
```

34. Q: What is the purpose of the `@PatchMapping` annotation in Spring REST?
    
    A: The `@PatchMapping` annotation is used to map HTTP PATCH requests to specific handler methods.

Example:
```java
@PatchMapping("/users/{id}")
public User patchUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    // Code to apply partial updates to the user with the given ID
}
```

35. Q: What is the purpose of the `@RequestParam` annotation in Spring REST?
    
    A: The `@RequestParam` annotation is used to extract query parameters from the URL.

Example:
```java
@GetMapping("/users")
public List<User> getUsersByRole(@RequestParam String role) {
    // Code to retrieve users by role
}
```

36. Q: What is the purpose of the `@RequestHeader` annotation in Spring REST?
    
    A: The `@RequestHeader` annotation is used to extract values from HTTP headers.

Example:
```java
@GetMapping("/users")
public List<User> getUsers(@RequestHeader("Authorization") String token) {
    // Code to retrieve users based on the authorization token
}
```

37. Q: What is the purpose of the `@PathVariable` annotation in Spring REST?
    
    A: The `@PathVariable` annotation is used to extract values from URI path variables.

Example:
```java
@GetMapping("/users/{id}")
public User getUserById(@PathVariable Long id) {
    // Code to retrieve user by ID


}
```

38. Q: What is the purpose of the `@RequestBody` annotation in Spring REST?
    
    A: The `@RequestBody` annotation is used to map the request body of an HTTP request to a method parameter.

Example:
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // Code to create a new user
}
```

39. Q: What is the purpose of the `@ModelAttribute` annotation in Spring REST?
    
    A: The `@ModelAttribute` annotation is used to bind method parameters to model attributes.

Example:
```java
@PostMapping("/users")
public User createUser(@ModelAttribute User user) {
    // Code to create a new user
}
```

40. Q: What is the purpose of the `@ResponseBody` annotation in Spring REST?
    
    A: The `@ResponseBody` annotation is used to indicate that the return value of a method should be written directly to the HTTP response body.

Example:
```java
@GetMapping("/hello")
@ResponseBody
public String sayHello() {
    return "Hello, world!";
}
```

41. Q: What is the purpose of the `@RestController` annotation in Spring REST?
    
    A: The `@RestController` annotation is a specialized version of `@Controller` that combines `@Controller` and `@ResponseBody`.

Example:
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
```

42. Q: What is the purpose of the `@RestControllerAdvice` annotation in Spring REST?
    
    A: The `@RestControllerAdvice` annotation is used to define global exception handling for REST controllers.

Example:
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

43. Q: How can you implement content negotiation in Spring REST APIs?
    
    A: You can implement content negotiation in Spring REST APIs by using the `produces` attribute in the `@RequestMapping` annotation or by setting the `Accept` header in the HTTP request.

Example with `produces` attribute:
```java
@GetMapping(value = "/data", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public Data getData() {
    // Code to retrieve data
}
```

Example with `Accept` header:
```java
curl -H "Accept: application/json" http://example.com/data
```

44. Q: What is the purpose of the `MediaType` class in Spring REST?
    
    A: The `MediaType` class in Spring REST is used to represent Internet Media Types (MIME types) for HTTP requests and responses.

Example:
```java
@GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public Data getData() {
    // Code to retrieve data
}
```

45. Q: What is the purpose of the `@CrossOrigin` annotation in Spring REST?
    
    A: The `@CrossOrigin` annotation is used to enable CORS (Cross-Origin Resource Sharing) for specific controller methods.

Example:
```java
@RestController
public class HelloController {
    @CrossOrigin(origins = "http://example.com")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
```

46. Q: How can you handle file uploads in Spring REST APIs?
    
    A: You can handle file uploads in Spring REST APIs by using the `@RequestParam` annotation with `MultipartFile`.

Example:
```java
@PostMapping("/upload")
public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    // Code to handle file upload
}
```

47. Q: How can you handle file downloads in Spring REST APIs?
    
    A: You can handle file downloads in Spring REST APIs by using the `ResponseEntity` class to set the appropriate response headers.

Example:
```java
@GetMapping("/download")
public ResponseEntity<Resource> downloadFile() throws IOException {
    // Code to read the file and create Resource object
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=myfile.txt");
    return ResponseEntity.ok()
            .headers(headers)
            .body(resource);
}
```

48. Q: What is the purpose of the `Pageable` interface in Spring REST?
    
    A: The `Pageable` interface in Spring REST is used to represent pagination information.

Example:
```java
@GetMapping("/users")
public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userRepository.findAll(pageable);
}
```

49. Q: How can you implement versioning in Spring REST APIs?
    
    A: You can implement versioning in Spring REST APIs by using URL versioning, request header versioning, or content negotiation versioning.

Example using URL versioning:
```java
@RestController
@RequestMapping("/v1")
public class UserControllerV1 {
    // REST endpoints for version 1
}

@RestController
@RequestMapping("/v2")
public class UserControllerV2 {
    // REST endpoints for version 2
}
```

Example using request header versioning:
```java
@RestController
public class UserController {
    @GetMapping(value = "/users", headers = "api-version=1")
    public List<User> getUsersV1() {
        // Code to retrieve users for version 1
    }

    @GetMapping(value = "/users", headers = "api-version=2")
    public List<User> getUsersV2() {
        // Code to retrieve users for version 2
    }
}
```

Example using content negotiation versioning:
```java
@RestController
public class UserController {
    @GetMapping(value = "/users", produces = "application/vnd.myapp.v1+json")
    public List<User> getUsersV1() {
        // Code to retrieve users for version 1
    }

    @GetMapping(value = "/users", produces = "application/vnd.myapp.v2+json")
    public List<User> getUsersV2() {
        // Code to retrieve users for version 2
    }
}
```

50. Q: What is the purpose of the `PathMatcher` in Spring REST?
    
    A: The `PathMatcher` in Spring REST is used to match and extract URI template variables from request URIs.

Example:
```java
@RestController
@RequestMapping("/users/{id}")
public class UserController {
    @GetMapping
    public User getUser(@PathVariable("id") Long id) {
        // Code to retrieve user by ID
    }
}
```

Remember to tailor your answers and examples based on your own understanding and experiences. Spring REST API is a vast topic, so be prepared to explain concepts thoroughly during your interview. Good luck!